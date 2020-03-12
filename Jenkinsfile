pipeline {
  agent any
  stages {
    stage('Lint') {
      steps {
        withGradle() {
            sh './gradlew clean ktlintCheck'
        }
      }
    }

  }
}