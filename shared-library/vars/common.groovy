def compile() {
    if (env.codeType == "python" | env.codeType == "static") {
        return "return, do not need compilation"
    }

    stage('Compile Code') {
        if (env.codeType == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }
        if (env.codeType == "nodejs") {
            sh 'npm install'
        }
    }
}

def test() {
    stage('Test Cases') {
        if (env.codeType == "maven") {
            sh '/home/centos/maven/bin/mvn test'
        }
        if (env.codeType == "nodejs") {
            sh 'npm test'
        }
        if (env.codeType == "python") {
            sh 'python3.6 -m unittest'
        }
    }
}

def codeQuality() {
    stage('Code Quality') {
        print 'Code Quality'
    }
}

def codeSecurity() {
    stage('Code Security') {
        print 'Code Security'
    }
}

def release() {
    stage('Release') {
        print 'Release'
    }
}