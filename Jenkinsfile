node {
    def WORKSPACE = "/var/lib/jenkins/workspace/restservice-deploy"
    def dockerImageTag = "restservice-deploy${env.BUILD_NUMBER}"

    try{
//          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/MartynovaIrina/SpringBoot_WebTours.git',
                credentialsId: 'MartynovaIrina',
                branch: 'master'
         }
          stage('Build docker') {
                 dockerImage = docker.build("webtours-docker:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop webtours-docker || true && docker rm webtours-docker || true"
                  sh "docker run --name webtours-docker -d -p 8081:8081 webtours-docker:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}