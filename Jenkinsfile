pipeline {
    agent any

    tools {
        // Asegurate de que el nombre 'Maven' coincida con como lo llamaste en Global Tool Configuration
        maven 'Maven 3.9.12'
    }

    stages {
        stage('Descargar Código') {
            steps {
                // Jenkins lo hace automático, pero es bueno declararlo
                checkout scm
            }
        }

        stage('Compilar y Testear') {
            steps {
                // Comando para ejecutar los tests en Windows
                bat 'mvn clean verify'
            }
        }
    }

    // --- AQUÍ ESTÁ LO NUEVO ---
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
    // --------------------------
}