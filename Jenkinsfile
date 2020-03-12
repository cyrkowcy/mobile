pipeline {
  agent any
  stages {
    stage('Lint') {
      steps {
        withGradle() {
            sh 'chmod +x gradlew'
            sh './gradlew clean ktlintCheck'
        }
      }
    }

  }
}