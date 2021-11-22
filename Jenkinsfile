pipeline {
    environment {
        registry = "jacobwestwellnetcompany/concept"
        registryCredential = 'docker-hub'
        dockerImage = ''
    }

    agent any

    triggers {
        pollSCM 'H/5 * * * *'
    }

    stages {
        stage('Build Application') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew assemble'
            }
        }

        stage('Test Application Build') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Build Docker Image') {
           app = docker.build(registry)
        }

        stage('Test Docker Image') {
            app.inside {
                sh 'echo "Image built!"'
            }
        }

        stage('Push Docker Image') {
            docker.withRegistry('https://registry.hub.docker.com', registryCredential) {
                dockerImage.push("${env.BUILD_NUMBER}")
            }
        }
    }
}