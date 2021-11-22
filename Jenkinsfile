node {
    def app

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
       app = docker.build("jacobwestwellnetcompany/concept")
    }

    stage('Test Docker Image') {
        app.inside {
            sh 'echo "Image built!"'
        }
    }

    stage('Push Docker Image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}