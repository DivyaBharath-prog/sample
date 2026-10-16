
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Java') {
            steps {
                bat 'java -version'
                bat 'javac -version'
            }
        }

        stage('Compile') {
            steps {
                bat 'javac HelloJenkins.java'
            }
        }

        stage('Run Application') {
            steps {
                bat 'java HelloJenkins'
            }
        }
    }

    post {
        success {
            echo 'Java CI Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check Console Output.'
        }
    }
}
