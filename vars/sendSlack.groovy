def call(String status) {
    def color = (status == 'SUCCESS') ? '#00FF00' : '#FF0000'
    def message = "Build #${env.BUILD_NUMBER} de ${env.JOB_NAME} - Statut : ${status}"
    
    // Utilise le plugin Slack de Jenkins
    slackSend(channel: '#ci-cd', color: color, message: message)
}