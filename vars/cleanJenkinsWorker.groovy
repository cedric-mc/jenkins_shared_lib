def call() {
    echo "=== Début du nettoyage du Worker Jenkins ==="
    
    // 1. Nettoyage de l'espace de travail Jenkins (fichiers locaux)
    try {
        cleanWs() // Plugin Jenkins 'Workspace Cleanup' requis, supprime les node_modules/dist locaux
        echo "✓ Espace de travail de build nettoyé avec succès."
    } catch (Exception e) {
        echo "⚠️ Impossible d'utiliser cleanWs(), le plugin n'est peut-être pas installé : ${e.message}"
    }

    // 2. Nettoyage des résidus Docker (images intermédiaires créées par le Multi-stage build)
    // Le '|| true' évite que le pipeline plante si Docker n'a rien à nettoyer
    echo "Nettoyage des caches et images Docker orphelines..."
    sh "docker image prune -f || true"
    
    echo "=== Fin du nettoyage ==="
}