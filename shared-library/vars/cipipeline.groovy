
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
                when {
                    expression { BRANCH_NAME == "main" }
                }
                steps {
                    echo 'Hello World'
                }
            }
            stage('Release') {
                when {
                    expression { env.TAG_NAME ==~ ".*" }
                }
                steps {
                    echo 'Hello World'
                }
            }
        }
    }
}