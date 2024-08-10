def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}

def call() {
    pipeline {
        agent any

        stages {
            stage('Compile Code') {
                steps {
                    echo 'Hello World'
                    script {
                        info 'Starting'
                        warning 'Nothing to do!'
                    }
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
                steps {
                    echo 'Hello World'
                }
            }
        }
    }
}