pipeline {
    agent any
 
    options {
        timestamps()
        skipDefaultCheckout(true)
    }
 
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Source code checked out successfully'
            }
        }
 
        stage('Environment Check') {
            steps {
                bat 'java -version'
                bat 'javac -version'
                bat 'git --version'
            }
        }
 
        stage('Compile') {
            steps {
                bat 'javac HelloJenkins.java'
                echo 'Java compilation successful'
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
            echo 'JAVA CI PIPELINE: SUCCESS'
        }
        failure {
            echo 'JAVA CI PIPELINE: FAILURE - Check Console Output'
        }
        always {
            echo 'Pipeline execution completed'
        }
    }
}
