def call() {
  sh "docker push saljuboori/demo-app:${env.IMAGE_NAME}"    
}
