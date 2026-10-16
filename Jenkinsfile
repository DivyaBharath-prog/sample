
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
                bat 'javac HelloCI.java'
            }
        }

        stage('Run Application') {
            steps {
                bat 'java HelloCI'
            }
        }
    }

    post {
        always {
            script {
                def buildStatus = currentBuild.currentResult

                withCredentials([
                    string(
                        credentialsId: 'slack-webhook-url',
                        variable: 'SLACK_WEBHOOK_URL'
                    )
                ]) {
                    powershell '''
                        $message = "$env:BUILD_STATUS"
                        $message = "$env:JOB_NAME build #$env:BUILD_NUMBER - $message"
                        $message += "`nBuild details: $env:BUILD_URL"

                        $body = @{ text = $message } |
                            ConvertTo-Json -Compress

                        Invoke-RestMethod `
                            --Uri $env:SLACK_WEBHOOK_URL ` `
                            -Method Post `
                            -ContentType "application/json" `
                            -Body $body
                    '''
                }
            }
        }

        success {
            echo 'SUCCESS: Java CI Pipeline completed!'
        }

        failure {
            echo 'FAILED: Check the Console Output.'
        }
    }
}
