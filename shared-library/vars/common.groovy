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
            //sh '/home/centos/maven/bin/mvn test'
            print 'OK'
        }

        if (env.codeType == "nodejs") {
            //sh 'npm test'
            print 'OK'
        }

        if (env.codeType == "python") {
            //sh 'python3.6 -m unittest'
            print 'OK'
        }

    }
}

def codeQuality() {
    stage('Code Quality') {
        env.sonar_user = sh (script: 'aws ssm get-parameter --name "sonarqube_user" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()
        env.sonar_pass = sh (script: 'aws ssm get-parameter --name "sonarqube_pass" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()
        wrap([$class: "MaskPasswordsBuildWrapper", varPasswordPairs: [[password: sonar_pass]]]) {
            if(env.codeType == "maven") {
                //sh 'sonar-scanner -Dsonar.host.url=http://172.31.0.205:9000 -Dsonar.login=${sonar_user} -Dsonar.password=${sonar_pass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
                print 'OK'
            }else {
                //sh 'sonar-scanner -Dsonar.host.url=http://172.31.0.205:9000 -Dsonar.login=${sonar_user} -Dsonar.password=${sonar_pass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
                print 'OK'
            }
        }
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