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
                 dockerImage = docker.build("WebTours_pipeline:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop WebTours_pipeline || true && docker rm WebTours_pipeline || true"
                  sh "docker run --name WebTours_pipeline -d -p 8081:8081 WebTours_pipeline:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}