pipeline {
    agent any

    // CONFIGURACIÓN DE HORARIO: 14:30 del 31 de Diciembre
    triggers {
        cron('30 14 31 12 *')
    }

    tools {
        maven 'Maven 3.9.12'
    }

    stages {
        stage('Descargar Código') {
            steps {
                checkout scm
            }
        }

        stage('Compilar y Testear') {
            steps {
                bat 'mvn clean verify'
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'Reporte Serenity',
                reportTitles: 'Resultados de Pruebas'
            ])
        }
    }
}