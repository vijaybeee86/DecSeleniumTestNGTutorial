pipeline {
  agent any
  stages {
 
        stage('Build') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=QA -Dbrowser=chrome'
          }
        }

      
    

    stage('Publish reports') {
      steps {
        script {
        
         // publish html
        		publishHTML([
        		allowMissing: false, 
        		alwaysLinkToLastBuild: false, 
        		keepAll: false, 
        		reportDir: 'TestResults', 
        		reportFiles: 'TestExecutionReport.html', 
        		reportName: 'Extent HTML Report',
        		 reportTitles: ''
        		 ])
     
        }

      }
    }

  }
  tools {
    maven 'MAVEN_HOME'
  }
}
