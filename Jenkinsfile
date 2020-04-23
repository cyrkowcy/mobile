pipeline {
  agent any
  tools {
    jdk "java8"
  }
  stages {
    stage('Lint check') {
      steps {
        withGradle() {
          sh 'chmod +x gradlew'
          sh './gradlew clean ktlintCheck'
        }
      }
    }
  }
}
