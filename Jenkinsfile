pipeline {
    agent any

    environment {
        IMAGE_NAME = 'withstudy-app'
        CONTAINER_NAME = 'withstudy-app'
        APP_PORT = '8080'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📦 소스코드 체크아웃...'
                checkout scm
            }
        }

        stage('Build Jar') {
            steps {
                echo '🔨 Gradle 빌드...'
                sh '''
                    chmod +x ./gradlew
                    ./gradlew clean build -x test
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                echo '🐳 Docker 이미지 빌드...'
                sh '''
                    docker build -t ${IMAGE_NAME}:latest .
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 컨테이너 배포...'
                sh '''
                    # 기존 컨테이너 중지 및 제거
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true

                    # 새 컨테이너 실행
                    docker run -d \
                        --name ${CONTAINER_NAME} \
                        --network withstudy_default \
                        -p ${APP_PORT}:8080 \
                        -e SPRING_DATASOURCE_URL=jdbc:mysql://withstudy-db:3306/study \
                        -e SPRING_DATASOURCE_USERNAME=study \
                        -e SPRING_DATASOURCE_PASSWORD=study \
                        -e TZ=Asia/Seoul \
                        ${IMAGE_NAME}:latest
                '''
            }
        }

        stage('Health Check') {
            steps {
                echo '❤️ 헬스체크...'
                sh '''
                    sleep 15
                    docker ps | grep ${CONTAINER_NAME}
                '''
            }
        }
    }

    post {
        success {
            echo '✅ 배포 성공!'
        }
        failure {
            echo '❌ 배포 실패! 로그 확인:'
            sh 'docker logs ${CONTAINER_NAME} || true'
        }
        always {
            echo '🧹 오래된 이미지 정리...'
            sh 'docker image prune -f || true'
        }
    }
}