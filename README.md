minikube delete
minikube start

# Build the docker container in a way that minikube can find it
# https://stackoverflow.com/questions/42564058/how-to-use-local-docker-images-with-minikube
eval $(minikube docker-env)
(cd simpleapp && ./gradlew clean build && docker build --build-arg JAR_FILE=build/libs/simpleapp-0.0.1-SNAPSHOT.jar -t kubedemo/statelessapp .)
(cd statefulapp && ./gradlew clean build && docker build --build-arg JAR_FILE=build/libs/statefulapp-0.0.1-SNAPSHOT.jar -t kubedemo/statefulapp .)

helm install demo demo

minikube service demo-demo-loadbalancer
minikube service demo-statefulapp-loadbalancer

# Prove pods can see each other via headless services suffixed dns names
kubectl exec --stdin --tty demo-statefulapp-1 -- ping demo-statefulapp-0.demo-statefulapp.default.svc.cluster.local 

# for demo purposes?
minikube dashboard
