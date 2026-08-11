def call(String imageName) {
    echo "building docker image..."
    echo "Image name received: ${imageName}"

withCredentials([
    usernamePassword(
        credentialsId: 'saifdockerhub',
        passwordVariable: 'PASSWORD',
        usernameVariable: 'USERNAME'
    )
]) {
    sh "docker build -t $imageName ."

    sh 'echo "Docker username: $USERNAME"'

    sh 'echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin'

    sh 'docker info 2>/dev/null | grep Username || true'

    sh "docker images | grep demo-app"

    sh "docker push $imageName"
  }
}    
