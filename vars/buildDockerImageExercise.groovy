def call() {
  sh "docker build -t saljuboori/demo-app:${env.IMAGE_NAME} ."    
}
