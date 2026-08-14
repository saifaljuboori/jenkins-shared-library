def call() {
    dir("app") {
        sh "npm version minor --no-git-tag-version"

        def version = sh(
            script: "node -p \"require('./package.json').version\"",
            returnStdout: true
        ).trim()

        env.IMAGE_NAME = "${version}"

        return version
    }
}
