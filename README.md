helm install demo demo

# Build the docker container in a way that minikube can find it
# https://stackoverflow.com/questions/42564058/how-to-use-local-docker-images-with-minikube
eval $(minikube docker-env)
docker build --build-arg JAR_FILE=build/libs/simpleapp-0.0.1-SNAPSHOT.jar -t kubedemo/simpleapp .

