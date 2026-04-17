pipeline {
    agent any
    
    tools {
        maven 'M3' // Ensure this matches the name in Jenkins Global Tool Config
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com'
            }
        }

        stage('Build & Test') {
            steps {
                // Runs Maven clean package which executes JUnit tests automatically
                sh 'mvn clean package'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                // Builds the image locally
                sh 'docker build -t food-delivery:local .'
            }
        }

        stage('K8s Deployment') {
            steps {
                // Deploys to your local Kubernetes (Minikube/Docker Desktop)
                sh 'kubectl apply -f k8s-local.yaml'
            }
        }
    }
}
