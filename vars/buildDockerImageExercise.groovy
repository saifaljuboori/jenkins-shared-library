def call() {
  sh "docker build -t saljuboori/demo-app:${IMAGE_NAME} ."    
}
