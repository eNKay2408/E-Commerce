pipeline {
  agent any

  triggers {
    pollSCM "* * * * *"
  }

  tools {
    maven "3.9"
  }

  environment {
    EC2_HOST_IP=credentials("ec2-host-ip")
    EC2_SSH_KEY=credentials("ec2-ssh-key")
    EC2_USER="ec2-user"

    DOCKERHUB=credentials("dockerhub-access")
    IMAGE="enkay2408/e-commerce"
    CONTAINER="e-commerce"

    SPRING_ENV_FILE=credentials("spring-env-file")
  }

  stages {
    stage("Create .env file") {
      steps {
        sh """
          cp $SPRING_ENV_FILE .env
          chmod 600 .env
        """
      }
    }

    stage("Build app") {
      steps {
        sh "mvn dependency:go-offline"
        sh "mvn clean package -DskipTests"
      }
    }

    stage("Build Docker Image") {
      steps {
        sh "docker login -u $DOCKERHUB_USR -p $DOCKERHUB_PSW"
        sh "docker build -t $IMAGE ."
        sh "docker push $IMAGE"
      }
    }

    stage("Deploy to EC2") {
      steps {
        sh """
          ssh -o StrictHostKeyChecking=no -i $EC2_SSH_KEY $EC2_USER@$EC2_HOST_IP '
            docker rm -f $CONTAINER || true
            docker rmi $IMAGE || true
            docker run -dp 8080:8080 --name $CONTAINER $IMAGE
          '
        """
      }
    }
  }
}