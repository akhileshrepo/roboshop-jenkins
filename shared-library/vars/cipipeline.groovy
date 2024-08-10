
def call() {
    pipeline {
        agent any

        stages {
            stage('Compile Code') {
                steps {
                    sh 'env'
                }
            }
            stage('Test') {
                steps {
                    echo 'Hello World'
                }
            }
            stage('Build') {
                steps {
                    echo 'Hello World'
                }
            }
            stage('Code Quality') {
                steps {
                    echo 'Hello World'
                }
            }
            stage('Code Security') {
                expression { BRANCH_NAME == "main" }
                steps {
                    echo 'Hello World'
                }
            }
            stage('Release') {
                steps {
                    echo 'Hello World'
                }
            }
        }
    }
}