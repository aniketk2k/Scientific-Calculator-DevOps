pipeline {
    agent any

    stages {
        stage('Checkout SCM'){
            steps {
                git branch: 'master', url: 'https://github.com/aniketk2k/Scientific-Calculator-DevOps.git'
            }
        }

        stage('Build and Test'){
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image'){
            steps {
                sh 'docker build -t scientific_calculator .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'

                    sh 'docker tag scientific_calculator aniketk2k/scientific_calculator:latest'

                    sh 'docker push aniketk2k/scientific_calculator:latest'
                }
            }
        }

        stage('Run Ansible Playbook'){
            steps{
                sh 'ansible-playbook ansible/deploy.yml'
            }
        }
    }

    post{
        success {
            mail to: 'forwebsitesaniket@gmail.com',
            subject: "Jenkins Build SUCCESS: Scientific Calculator",
            body: "The Jenkins pipeline completed successfully."
        }
        failure {
            mail to: 'forwebsitesaniket@gmail.com',
            subject: "Jenkins Build FAILED: Scientific Calculator",
            body: "The Jenkins pipeline failed. Check Jenkins logs."
        }
    }
}