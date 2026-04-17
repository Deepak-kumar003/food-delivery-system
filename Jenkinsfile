pipeline {
    agent any
    tools { maven 'M3' }
    stages {
        stage('Unit Testing') {
            steps {
                // Runs JUnit tests automatically
                sh 'mvn test'
            }
        }
        stage('Package Application') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Image Build') {
            steps {
                // Builds image on your local Docker Desktop
                sh 'docker build -t food-delivery:local .'
            }
        }
        stage('K8s Local Deploy') {
            steps {
                // Updates your local K8s cluster
                sh 'kubectl apply -f k8s-local.yaml'
                sh 'kubectl rollout restart deployment food-app'
            }
        }
    }
}
