def call() {
    echo "Building JAR..."

    sh 'mvn package'
}
