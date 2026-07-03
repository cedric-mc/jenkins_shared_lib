def call(String status) {
    def color = (status == 'SUCCESS') ? '#00FF00' : '#FF0000'
    def message = "Build #${env.BUILD_NUMBER} de ${env.JOB_NAME} - Statut : ${status}"
    
    // Vérifie si le plugin Slack est installé avant de l'appeler
    if (metaClass.getMetaMethod("slackSend", Map) || this.respondsTo("slackSend", Map)) {
        slackSend(channel: '#ci-cd', color: color, message: message)
    } else {
        echo "📢 [Notification] Plugin Slack absent du serveur. Message : ${message}"
    }
}