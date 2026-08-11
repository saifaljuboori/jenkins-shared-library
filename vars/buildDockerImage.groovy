def call() {
    echo "building docker image..."

    withCredentials([
        usernamePassword(
            credentialsId: 'saifdockerhub',
            passwordVariable: 'PASSWORD',
            usernameVariable: 'USERNAME'
                        )
    ]) {
        sh 'docker build -t saljuboori/demo-app:jma-3.0 .'
        sh 'echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin'
        sh 'docker push saljuboori/demo-app:jma-3.0'
   }
}
