def call() {
    echo "Increment Version..."

    sh "mvn build-helper:parse-version versions:set '-DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion}' versions:commit"
}
