def call() {
    echo "Deploying & running server on EC2..."

    def ec2Server = ${ec2-user@3.90.251.184}
    def dockerCmd = "docker run -d -p 8080:8080 ${imageName}"
    sshagent(credentials: ['ec2-server-key'], executable: '') {
        sh "ssh -o StrictHostKeyChecking=no ${ec2Server} ${dockerCmd}"
    }
}