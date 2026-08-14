def call() {
    echo "Committing updated application version..."

    withCredentials([
        usernamePassword(
            credentialsId: 'github-credentials',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
        )
    ]) {
        sh '''
            git config user.name "Jenkins"
            git config user.email "jenkins@example.com"

            git add .
            git commit -m "chore: increment application version [skip ci]"

            git push https://${USERNAME}:${PASSWORD}@github.com/saifaljuboori/jenkins-exercises.git HEAD:master
        '''
    }
}
