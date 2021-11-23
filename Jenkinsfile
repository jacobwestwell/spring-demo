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

//         stage('Test Application Build') {
//             steps {
//                 sh './gradlew test'
//             }
//         }

//         stage('Build Docker Image') {
//             steps {
//                 script {
//                     dockerImage = docker.build registry
//                 }
//             }
//         }

//         stage('Push Docker Image') {
//             steps {
//                 script {
//                     docker.withRegistry('https://registry.hub.docker.com', registryCredential) {
//                         dockerImage.push()
//                     }
//                 }
//             }
//         }
    }
}