def call(Map config = [:]) {
    // On définit des valeurs par défaut si non spécifiées
    def imageName = config.imageName ?: env.JOB_NAME.toLowerCase()
    def tag = config.tag ?: "build-${env.BUILD_NUMBER}"
    def registry = config.registry ?: ""

    def fullImageUri = registry ? "${registry}/${imageName}:${tag}" : "${imageName}:${tag}"

    echo "Construction de l'image : ${fullImageUri}"
    sh "docker build -t ${fullImageUri} ."

    if (registry) {
        echo "Push de l'image sur le registre..."
        sh "docker push ${fullImageUri}"
    }
}