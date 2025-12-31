pipeline {
    agent any

    tools {
        // Asegurate de que el nombre 'Maven' coincida con como lo llamaste en Global Tool Configuration de Jenkins
        // Si no le pusiste nombre, avísame. Por ahora probemos sin 'tools' si ya está en el Path,
        // o usa el nombre que le diste (ej: 'M3', 'Maven 3.9', etc.)
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
}