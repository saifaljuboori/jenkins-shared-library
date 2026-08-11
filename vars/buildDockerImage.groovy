def call(String imageName) {
    echo "building docker image..."

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-test',
            passwordVariable: 'PASSWORD',
            usernameVariable: 'USERNAME'
        )
    ]) {
        sh "docker build -t $imageName ."
        sh 'echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin'
        sh "docker push $imageName"
    }
}
