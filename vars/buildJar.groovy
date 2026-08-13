def call() {
    echo "Building JAR..."

    sh 'mvn clean package'
}
