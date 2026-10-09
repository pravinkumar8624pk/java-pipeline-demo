
pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('1. Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('2. Code Review') {
            steps {
                echo 'Code review stage'
                echo 'Configure SonarQube to run code quality analysis'
            }
        }

        stage('3. Unit Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('4. Coverage') {
            steps {
                sh 'mvn verify'
                archiveArtifacts artifacts: 'target/site/jacoco/**',
                                 allowEmptyArchive: true
            }
        }

        stage('5. Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'All pipeline stages completed!'
        }
        failure {
            echo 'Pipeline failed. Check Console Output.'
        }
        always {
            archiveArtifacts artifacts: 'target/*.jar',
                             allowEmptyArchive: true
        }
    }
}
