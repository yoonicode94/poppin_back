pipeline {
  agent any
  stages {
    stage('git scm update') {
      steps {
        git url: 'https://github.com/yoonicode94/poppin_back', branch: 'master'
      }
    }
    stage('docker build and push') {
      steps {
        sh '''
        docker build --no-cache -t 192.168.1.10:8443/popup .
        docker push 192.168.1.10:8443/popup
        '''
      }
    }
    stage('deploy kubernetes') {
      steps {
        sh '''
        kubectl get service react-popup && kubectl delete -f service.yaml
        kubectl get deployment spring-boot-popup && kubectl delete -f deployment.yaml
        kubectl apply -f deployment.yaml
        kubectl apply -f service.yaml
        '''
      }
      
    }
  }
}
