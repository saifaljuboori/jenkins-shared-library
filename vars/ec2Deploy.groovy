def call() {
    echo "Deploying & running server on EC2..."

    def ec2Server = 'ec2-user@3.90.251.184'
    def dockerCmd = "docker stop demo-app || true && docker rm demo-app || true && docker run --name demo-app -d -p 8080:8080 ${env.IMAGE_NAME}"

    sshagent(credentials: ['ec2-server-key']) {
        sh "ssh -o StrictHostKeyChecking=no ${ec2Server} '${dockerCmd}'"
    }
}