pipeline {
  agent any

  triggers {
    pollSCM "* * * * *"
  }

  environment {
    DOCKERHUB=credentials("DOCKERHUB_ACCESS")
    EC2_IP=credentials("EC2_IP")
    IMAGE_NAME="enkay2408/ecommerce"

    DB=credentials("JAVA_DB_ACCESS")
    DB_URL=credentials("JAVA_DB_URL")
    GOOGLE_CLIENT=credentials("JAVA_GOOGLE_SECRET")
    STRIPE_SECRET_KEY=credentials("JAVA_STRIPE_SECRET")
    JWT_SECRET=credentials("JAVA_JWT_SECRET")
    CLOUDINARY_NAME=credentials("JAVA_CLOUDINARY_NAME")
    CLOUDINARY_API=credentials("JAVA_CLOUDINARY_SECRET")
  }

  stages {
    stage("Create .env file") {
      steps {
        sh '''
          echo "DB_USERNAME=$DB_USR" >> .env
          echo "DB_PASSWORD=$DB_PSW" >> .env
          echo "DB_URL=$DB_URL" >> .env
          echo "GOOGLE_CLIENT_ID=$GOOGLE_CLIENT_USR" >> .env
          echo "GOOGLE_CLIENT_SECRET=$GOOGLE_CLIENT_PSW" >> .env
          echo "STRIPE_SECRET_KEY=$STRIPE_SECRET_KEY" >> .env
          echo "JWT_SECRET=$JWT_SECRET" >> .env
          echo "CLOUDINARY_CLOUD_NAME=$CLOUDINARY_NAME" >> .env
          echo "CLOUDINARY_API_KEY=$CLOUDINARY_API_USR" >> .env
          echo "CLOUDINARY_API_SECRET=$CLOUDINARY_API_PSW" >> .env
        '''
      }
    }

    stage("Build Docker Image") {
      steps {
        sh "docker login -u $DOCKERHUB_USR -p $DOCKERHUB_PSW"
        sh "docker build -t $IMAGE_NAME ."
        sh "docker push $IMAGE_NAME"
      }
    }

    stage("Deploy to EC2") {
      steps {
        sshagent(credentials: ["EC2_SSH"]) {
          sh """
            ssh -o StrictHostKeyChecking=no ec2-user@$EC2_IP '
              docker rm -f ecommerce || true
              docker rmi $IMAGE_NAME || true
              docker run -dp 8080:8080 --name ecommerce $IMAGE_NAME
            '
          """
        }
      }
    }
  }
}