def compile() {
    sh 'find .'
    if (env.codeType == "maven") {
        print 'Maven'
    }
    if (env.codeType == "nodejs") {
        print 'NodeJs'
    }
    if (env.codeType == "python") {
        print 'python'
    }
    if (env.codeType == "static") {
        print 'static'
    }
}