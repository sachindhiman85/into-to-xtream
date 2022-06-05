node {

    stage("Git Clone.."){

        git credentialsId: 'BITBUCKET_PASS', url: 'https://sachindhiman85@bitbucket.org/sachindhiman85/into-to-xtream.git'
    }

     stage('Maven Build') {
       sh 'mvn clean build'
    }

    stage("Docker build"){
        sh 'docker version'
        sh 'docker build -t  .'
        sh 'docker image list'
        sh 'docker tag into-to-xtream sachindhiman85/into-to-xtream:into-to-xtream'
    }

    withCredentials([string(credentialsId: 'DOCKET_CREDENTIAL', variable: 'PASSWORD')]) {
        sh 'docker login -u sachindhiman85 -p $PASSWORD'
    }

    stage("Push Image to Docker Hub"){
        sh 'docker push  sachindhiman85/into-to-xtream:into-to-xtream'
    }

    /* stage("SSH Into k8s Server") {
        def remote = [:]
        remote.name = 'K8S master'
        remote.host = '100.0.0.2'
        remote.user = 'vagrant'
        remote.password = 'vagrant'
        remote.allowAnyHosts = true

        stage('Put k8s-spring-boot-deployment.yml onto k8smaster') {
            sshPut remote: remote, from: 'k8s-spring-boot-deployment.yml', into: '.'
        }

        stage('Deploy spring boot') {
          sshCommand remote: remote, command: "kubectl apply -f k8s-spring-boot-deployment.yml"
        }
    }
 */
}

