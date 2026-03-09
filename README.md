# DevOps CI/CD Pipeline for Scientific Calculator

This project demonstrates a complete **CI/CD pipeline implementation using DevOps tools**.  
The pipeline automates the process of **building, testing, containerizing, and deploying a Java-based Scientific Calculator application**.

The entire workflow is automated using **Jenkins, Docker, DockerHub, Ansible, and GitHub Webhooks**.

---

# Project Objective

The objective of this project is to implement a **Continuous Integration and Continuous Deployment (CI/CD) pipeline** that automatically:

- Builds the application
- Runs automated tests
- Creates a Docker container
- Pushes the container image to DockerHub
- Deploys the application using Ansible
- Sends build notifications via email

---

# Tools & Technologies Used

| Tool | Purpose |
|-----|------|
| Git | Version control |
| GitHub | Source code repository |
| Maven | Build automation |
| Jenkins | CI/CD pipeline automation |
| Docker | Containerization |
| DockerHub | Container registry |
| Ansible | Deployment automation |
| ngrok | Expose Jenkins to GitHub webhook |
| Gmail SMTP | Email notifications |

---

# Project Structure

```
Scientific-Calculator-DevOps
│
├── src/
│ ├── main/java/calculator
│ │ └── App.java
│ │
│ └── test/java/calculator
│ └── AppTest.java
│
├── ansible/
│ ├── deploy.yml
│ └── inventory.ini
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
```


---

# CI/CD Pipeline Workflow

The CI/CD pipeline performs the following steps:

1. Developer pushes code to **GitHub**

2. GitHub **Webhook triggers Jenkins Pipeline**

3. Jenkins performs:
   1. Build the project using **Maven**
   2. Run **unit tests**
   3. Package the application as a **JAR file**

4. Jenkins builds a **Docker Image**

5. Docker image is pushed to **DockerHub**

6. **Ansible Playbook deploys the container**

7. **Email notification** is sent to the developer

---

# CI/CD Architecture

```
Developer
   │
   ▼
GitHub Repository
   │
   ▼
GitHub Webhook
   │
   ▼
ngrok Tunnel
   │
   ▼
Jenkins Pipeline
   │
   ├── Maven Build & Test
   ├── Docker Image Build
   ├── Push Image to DockerHub
   └── Run Ansible Playbook
   │
   ▼
Docker Container Deployment
   │
   ▼
Email Notification
```

---

# Docker Image

DockerHub Repository:

```
https://hub.docker.com/r/aniketk2k/scientific_calculator
```

To run the container manually:

```
docker run -it aniketk2k/scientific_calculator
```

---

# Jenkins Pipeline Stages

The Jenkins pipeline consists of the following stages:

1. Checkout Source Code
2. Build and Test using Maven
3. Build Docker Image
4. Push Docker Image to DockerHub
5. Deploy using Ansible
6. Send Email Notification

---

# Email Notifications

Jenkins is configured with **SMTP email notifications**.

Notifications are sent when:

- Build succeeds
- Build fails

---

# GitHub Webhook Automation

GitHub Webhooks are configured to automatically trigger the Jenkins pipeline whenever new code is pushed.

ngrok is used to expose the local Jenkins server to GitHub.

---

# How to Run the Project

Clone the repository:

```
git clone https://github.com/aniketk2k/Scientific-Calculator-DevOps.git
```

Navigate to the project:

```
cd Scientific-Calculator-DevOps
```

Build using Maven:

```
mvn clean package
```

Run the application:

```
java -jar target/scientific_calculator-1.0-SNAPSHOT.jar
```

---

# Running Tests

Run unit tests using:

```
mvn test
```
