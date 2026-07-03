def call() {
    echo "Nettoyage des ressources Docker inutilisées..."

    sh "docker container prune -f || true"
    sh "docker image prune -f || true"
}