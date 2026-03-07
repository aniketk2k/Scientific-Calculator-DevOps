pipeline {
    agent any

    stages {

        stage('Checkout SCM') {
            steps {
                git branch: 'master', url: 'https://github.com/aniketk2k/Scientific-Calculator-DevOps.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t scientific_calculator .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker tag scientific_calculator aniketk2k/scientific_calculator:latest'
                sh 'docker push aniketk2k/scientific_calculator:latest'
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                sh 'ansible-playbook ansible/deploy.yml --ask-become-pass'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
