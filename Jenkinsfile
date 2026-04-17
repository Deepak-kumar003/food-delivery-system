pipeline {
    agent any
    tools { 
        maven 'M3' 
    }
    stages {
        stage('Unit Testing') {
            steps {
                // Changed 'sh' to 'bat' for Windows
                bat 'mvn test'
            }
        }
        stage('Package Application') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Image Build') {
            steps {
                bat 'docker build -t food-delivery:local .'
            }
        }
        stage('K8s Local Deploy') {
            steps {
                bat 'kubectl apply -f k8s-local.yaml'
                bat 'kubectl rollout restart deployment food-app'
            }
        }
    }
}
