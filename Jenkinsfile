node {
    def WORKSPACE = "/var/lib/jenkins/workspace/WebTours_pipeline"
    def dockerImageTag = "WebTours_pipeline${env.BUILD_NUMBER}"

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
                 dockerImage = docker.build("webtourspipeline:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop webtourspipeline || true && docker rm webtourspipeline || true"
                  sh "docker run --name webtourspipeline -d -p 8081:8081 webtourspipeline:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}