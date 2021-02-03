docker rm -f scorecalculation
mvn clean install
docker rmi sumutella/scorecalculation
docker build -t sumutella/scorecalculation .
docker run -d -p 8099:8080 -e DATA_SOURCE_URL='jdbc:mysql://host.docker.internal:3307/scorecalculation' -e DATA_SOURCE_USERNAME='root' -e DATA_SOURCE_PASSWORD='root' --name scorecalculation sumutella/scorecalculation
