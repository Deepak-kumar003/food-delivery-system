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
                script {
            // Replace 'YourUsername' with the actual username you see in C:/Users/
                    def kubeConfigPath = "C:/Users/batch1/.kube/config"
            
            // Explicitly tell kubectl which 'ID card' to use
                    bat "kubectl --kubeconfig=${kubeConfigPath} apply -f k8s-local.yaml"
                    bat "kubectl --kubeconfig=${kubeConfigPath} rollout restart deployment food-app"
                }
            }
        }


    }
}
