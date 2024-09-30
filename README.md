<div align="center">

  # 🛒 E-Commerce

  *Seamless shopping and security experience with Spring Boot and JWT Authentication* 🔒

  ![ReactJS](https://img.shields.io/badge/Spring-black?style=for-the-badge&logo=spring&logoColor=6DB33F)
  ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-black?style=for-the-badge&logo=thymeleaf&logoColor=005F0F)
  ![Bootstrap](https://img.shields.io/badge/Bootstrap-black?style=for-the-badge&logo=bootstrap&logoColor=7952B3)

  ![Hibernate](https://img.shields.io/badge/hibernate-white?style=for-the-badge&logo=hibernate&logoColor=59666C)
  ![JWT](https://img.shields.io/badge/JWT-white?style=for-the-badge&logo=jsonwebtokens&logoColor=000000)
  ![Stripe](https://img.shields.io/badge/Stripe-white?style=for-the-badge&logo=stripe&logoColor=645cf5)

  ![Docker](https://img.shields.io/badge/Docker-0A2647?style=for-the-badge&logo=Docker&logoColor=2496ED)
  ![Jenkins](https://img.shields.io/badge/Jenkins/CD-0A2647?style=for-the-badge&logo=Jenkins&logoColor=eadbc0)
  ![AWS EC2](https://img.shields.io/badge/AWS_EC2-0A2647?style=for-the-badge&logo=amazonwebservices&logoColor=FF9900)

  <img width="595px" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361252/ECommerce/Screenshot/3-Home.png">

  [![Live Demo](https://img.shields.io/badge/🔗_Visit_website-white?style=flat)](https://e-commerce.enkay.live)

</div>

## 📘 Table of Contents
1. [Introduction](#introduction) 🧟
2. [Technologies](#technologies) 💻
3. [Features](#features) 🔎
4. [DevOps](#devops) ✈️
5. [Acknowledgements](#acknowledgements) 💙
6. [Contact](#contact) 🌐

## 🧟 <a name="introduction">Introduction</a>
*Welcome to E-Commerce, the **3rd** of 4 major projects I’ve built as part of my journey to create a strong portfolio for my first job application. As this is one of my first major project README files, some mistakes are to be expected. If you encounter any issues or need further support, please don't hesitate to reach out via the contact information below. I truly appreciate your understanding and thank you so much for taking the time to visit this project!* 😚

This is the project I felt most confident planning initially, mainly because I had a solid understanding of Spring Boot. At first, everything went smoothly, I followed tutorials and quickly completed both the front-end and back-end. But then, I wanted to push myself further, so I decided to integrate JWT authentication and implement Stripe for payments. That's when everything took a turn. The following days were filled with sleepless nights as I encountered error after error, diving deep into advanced security concepts to fix them. I even ran into issues when deploying with TLS. Looking back, it was a nightmare, but I’m proud that I persevered through it without giving up halfway, completing every goal set for the project.

This project significantly enhanced my understanding of security. Although it's just a basic CRUD application at its core, the security features I implemented are what I really take pride in. If I had the chance to improve it further, I’d probably experiment with more advanced cookies instead of localStorage, XD. Additionally, I learned a lot about responsive web design using pure HTML and Bootstrap, despite being more comfortable with React and TailwindCSS before. This is actually the project I enhanced the most on my own, as the tutorials I followed only covered the basics. As a result, it turned out to be the longest and most challenging project I’ve worked on.

## 💻 <a name="technologies">Technologies</a>

<div align="center">

  ![Technologies](https://skillicons.dev/icons?i=java,spring,bootstrap,mysql,hibernate,docker,jenkins,aws)

</div>

- **Spring:** Framework for building and securing the application.
- **Thymeleaf:** Server-side template engine for rendering HTML views.
- **Bootstrap:** CSS framework for responsive and mobile-first web design.
- **Hibernate:** ORM framework for database operations.
- **JWT:** Token-based authentication and authorization.
- **Stripe:** Payment processing integration.
- **Docker:** Containerization for consistent environments.
- **Jenkins:** CI/CD pipeline automation.
- **AWS EC2:** Cloud computing service for hosting the application.
- **AWS RDS:** Managed relational database service.

## 🔎 <a name="features">Features</a>

**🔷 Register:** Create an account with a unique email and password.

**🔷 Login:** Log in with your email and password or using Google OAuth.

**🔷 Admin Permission:** Only admin can manage categories and products.

**🔷 Add Product:** Admins can add product information, and images can be stored in the Cloudinary.

**🔷 Product Details:** View product details and add to cart.

**🔷 Friendly Shop:** Display all products, which can be filtered by category.

**🔷 Cart:** Show all products in the cart and total amount.

**🔷 Checkout:** Enter shipping information and pay with Stripe.

**NOTE:** 
- You can log in as an admin using the email `admin@enkay.live` and password `password`.
- The checkout process is not fully implemented, and the payment is not real, You can test it using the card number `4242 4242 4242 4242`.


  <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361253/ECommerce/Screenshot/1-Login.png" alt="Login"> <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361252/ECommerce/Screenshot/2-Register.png" alt="Register">

  <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361252/ECommerce/Screenshot/3-Home.png" alt="Home"> <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361253/ECommerce/Screenshot/4-Admin.png" alt="Admin">

  <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361253/ECommerce/Screenshot/5-Categories.png" alt="Categories"> <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361253/ECommerce/Screenshot/6-Products.png" alt="Products">

  <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361254/ECommerce/Screenshot/7-Add.png" alt="Add Product"> <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361254/ECommerce/Screenshot/8-Shop.png" alt="Shop">

  <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361254/ECommerce/Screenshot/9-Cart.png" alt="Cart"> <img width="49%" src="https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361252/ECommerce/Screenshot/10-Checkout.png" alt="Checkout">

## ✈️ <a name="devops">DevOps</a>

### Prerequisites
- [Git](https://git-scm.com/)
- [Java](https://www.oracle.com/java/)
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/)
- [AWS](https://aws.amazon.com/)

### 🖥️ Development 

#### 1. Clone the repository:
```
https://github.com/eNKay2408/E-Commerce.git
cd E-Commerce
```

#### 2. Set Up Environment Variables:
- Create a `.env` file in the directory and add the following environment variables:
  ```
  DB_USERNAME=your_db_username
  DB_PASSWORD=your_db_password
  DB_URL=your_db_url/e-commerce

  GOOGLE_CLIENT_ID=your_google_client_id
  GOOGLE_CLIENT_SECRET=your_google_client_secret

  STRIPE_SECRET_KEY=your_stripe_secret_key

  JWT_SECRET=your_jwt_secret

  CLOUDINARY_CLOUD_NAME=your_cloudinary_cloud_name
  CLOUDINARY_API_KEY=your_cloudinary_api_key
  CLOUDINARY_API_SECRET=your_cloudinary_api_secret
  ```
- Some useful resources to get the environment variables:
  - [MySQL](https://www.youtube.com/watch?v=BxdSUGBs0gM)
  - [Google OAuth](https://www.youtube.com/watch?v=HtJKUQXmtok)
  - [Stripe](https://www.youtube.com/watch?v=-g3nUV_y648)
  - [JWT secret](https://jwtsecret.com/generate)
  - [Cloudinary](https://www.youtube.com/watch?v=MMPHybpGXDc)

#### 3. Start the development
- For Mac/Linux: `./mvnw spring-boot:run`

- For Windows: `./mvnw.cmd spring-boot:run`

#### 4. See the changes reflected in real-time:
- Open [http://localhost:8080](http://localhost:8080) to view the application in the browser.

### 🔄 CI/CD - Jenkins

#### 1. Create Github repository and add remote URL to the local repository.

#### 2. Set up AWS EC2 instance:
- Launch an EC2 instance with the following configurations: Amazon Linux, t2.micro (free tier eligible) and open port `22`, `80`, `443` in the security group.

- Connect to the instance directly or [using SSH](https://www.youtube.com/watch?v=8UqtMcX_kg0) and install Docker and nginx on the server:
  ```
  sudo yum update -y
  sudo amazon-linux-extras install docker
  sudo systemctl start docker
  sudo systemctl enable docker
  sudo systemctl status docker
  sudo usermod -a -G docker ec2-user

  sudo yum install nginx
  sudo systemctl start nginx
  sudo systemctl enable nginx
  sudo systemctl status nginx
  ```

- Configure Nginx to reverse proxy the application to port `8080`. Follow the [tutorial video](https://www.youtube.com/watch?v=B62QSbPhh1s) for detailed instructions.
  ```
  location / {
    proxy_pass http://localhost:8080;
    ...
  }
  ```

#### 3. Set up RDS MySQL database (Optional):

- **NOTE**: You can use the MySQL database on the EC2 instance through Docker or install locally MySQL on the EC2 instance.
- Create a new RDS MySQL database with the following configurations: MySQL, Free tier eligible, No public and must be in the same VPC as the EC2 instance.
- Open inbound port `3306` in the RDS security group for the EC2 instance.
- Follow the [tutorial](https://www.youtube.com/watch?v=7e_mjVUV-zA) for create RDS MySQL database and test connection with EC2 instance (only replace `mariaDB` with `mysql`).
- Change the `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` in the `.env` file to the RDS MySQL database. 

#### 4. Run Jenkins on the local machine (You can also run Jenkins using other methods):
- Run Jenkins locally using Docker:
  ```
  docker run --name jenkins \ 
  -p 8080:8080 -p 50000:50000 \ 
  -v /var/run/docker.sock:/var/run/docker.sock \ 
  -v jenkins_home:/var/jenkins_home \ 
  jenkins/jenkins:lts-jdk17
  ```

- **Important** Get the Docker group ID on the host machine:
  ```
  cat /etc/group | grep docker
  ```

- Install Docker CLI and add permission for Jenkins user to run Docker commands (DinD):
  ```
  docker exec -u root -it jenkins bash
  apt update
  apt install docker.io
  docker --version

  groupdel docker
  groupadd -g <DOCKER_GROUP_ID_ON_HOST> docker
  usermod -a -G docker jenkins
  ```

- Exit and restart the Jenkins container.

#### 5. Configure Jenkins:
- Get the initial admin password from the Jenkins container:
  ```
  docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword
  ```

- Open [Jenkins](http://localhost:8080) on the browser, login and install the recommended plugins.

- Install `Maven` plugin and then go to Tools Configuration > Maven > Add Maven and set the name to `3.9` and install automatically.

- Set up credentials: 
  - Go to Manage Jenkins > Manage Credentials > Global Credentials > Add Credentials. Add the following credentials with `ID`.
  - Add AWS credentials (Secret text): `ec2-host-ip`, `ec2-ssh-key`
  - Add Docker Hub credentials (Username with password): `dockerhub-access`
  - Add application `.env` file (Secret file): `spring-env-file`

#### 6. Create a new Jenkins pipeline:
- Go to Jenkins dashboard and click on `New Item`.
- Create a new pipeline and go to the pipeline configuration.
- Choose `Pipeline script from SCM` and select `Git`.
- Add Github repository URL and change branch to build from `main`.

#### 7. Push the code to Github:
- Edit `IMAGE` in the `Jenkinsfile` to your Docker Hub repository name.
- Push the code to the Github repository.
- Click on `Build Now` in the Jenkins pipeline.
- Once the pipeline is successful, the application will be deployed to IP public AWS EC2.

![Successful Deployment](https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727361252/ECommerce/Screenshot/0-Jenkins.png)

**NOTE:** The pipeline will automatically build and deploy the application whenever changes are pushed to the Github repository as long as the container Jenkins server is running. Because I have already set up pollSCM in the `Jenkinsfile` to check for changes every 1 minute.

### 🌟 I hope it saves you time debugging, as I’ve already gone through the tough parts for you, `XD`. And if you found it useful, a star on this GitHub repository would mean the world to me!

## 💙 <a name="acknowledgements">Acknowledgements</a>

- **[Sheryians Coding School](https://www.youtube.com/@sheryians):** For the simple [tutorial](https://www.youtube.com/playlist?list=PLbtI3_MArDOlnBkBS-O04_YNIaZG4yetn) that helped me build the application.
- **[Docker](https://www.docker.com/):** For the free containerization service that helped me deploy the application.
- **[Jenkins](https://www.jenkins.io/):** For automating the build and deployment processes through CI/CD pipelines.
- **[AWS](https://aws.amazon.com/):** For the free tier EC2 and RDS services that helped me host and store data.
- **[Cloudinary](https://cloudinary.com/):** For the free image hosting service that helped me store and serve images.
- **[anmolbaranwal](https://dev.to/anmolbaranwal):** For the amazing [article](https://dev.to/anmolbaranwal/make-github-readme-like-pro-15am) that helped me create this beautiful README.

## 🌐 <a name="contact">Contact</a>

- **Name:** Nguyen Phan Duc Khai - **eNKay**
- **Portfolio:** [enkay.live](https://enkay.live)
- **LinkedIn:** [en-kay](https://www.linkedin.com/in/en-kay/)
- **Email:** [enkay.work@outlook.com](mailto:enkay.work@outlook.com)