def call(String appName, String version) {
    stage('Build from Shared Lib') {
        echo "Building ${appName} version ${version}"
        sh 'mvn clean package -DskipTests'
        sh "docker build -t ${appName}:${version} ."
        echo "${appName}:${version} built successfully!"
    }
}
