
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
                when {
                    expression { env.BRANCH_NAME ==~ ".*" }
                }
                steps {
                    echo 'Hello World'
                }
            }
            stage('Code Quality') {
                when {
                    allOf{
                        expression { env.BRANCH_NAME != null }
                        expression { env.TAG_NAME == null }
                    }
                }
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