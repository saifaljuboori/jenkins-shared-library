
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

        sh 'docker logout'
        sh 'echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin'
        sh "docker push $imageName"
    }
}

