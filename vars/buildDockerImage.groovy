def call(String imageName) {
    echo "building docker image..."

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

    sh "docker push $imageName"
}
