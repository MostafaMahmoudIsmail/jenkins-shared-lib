def buildApp() {
    echo "Building the project..."
    sh 'mvn clean package -DskipTests'
}

def dockerBuild(version) {
    echo "Building Docker image"
    sh "docker build -t python-iti-app:${version} ."
}

def deployApp(version, port = 8085) {
    echo "Deploying container version ${version} on port ${port}"
    sh "docker rm -f python-iti-app || true"
    sh "docker run -d -p ${port}:8080 --name python-iti-app python-iti-app:${version}"
    echo "Container is now running successfully!"
}

def cleanup() {
    echo "Cleaning workspace..."
    cleanWs()
}
