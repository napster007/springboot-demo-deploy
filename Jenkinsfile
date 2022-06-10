node {

    def WORKSPACE = "/var/lib/jenkins/workspace/springboot-demo-deploy"
    def dockerImageTag = "springboot-deploy${env.BUILD_NUMBER}"

    try{
            stage('Clone Repo'){
                git url: 'https://github.com/napster007/springboot-demo-deploy.git'
                credentialsId : 'githubdeploy-user'
                branch : 'master'
            }

            stage('Build Docker'){
                dockerImage = docker.build("springboot-demo-deploy${env.BUILD_NUMBER}")
            }

            stage('Deploy Docker'){
                echo "Docker Image Tag Name: ${dockerImageTag}"
                sh "docker stop springboot-demo-deploy || true && docker rm springboot-demo-deploy || true"
                sh "docker run --name springboot-demo-deploy -d -p 8099:8099 springboot-demo-deploy:${env.BUILD_NUMBER}"
            }
    }catch(e){
        throw e
    }
}
