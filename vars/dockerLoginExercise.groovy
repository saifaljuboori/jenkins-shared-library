def call() {
  withCredentials([usernamePassword(credentialsId: 'saifdockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            sh "echo '${PASSWORD}' | docker login -u '${USERNAME}' --password-stdin"
  }   
}  
