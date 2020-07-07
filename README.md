This project doesn't really have a unified build process, but with some determination you might just get everything to work!

In the `presentation` directory, there is a Makefile that will build the presentation. You'll need to have Docker installed. 
The Makefile builds Docker images for both Dia and Latex, which are needed to build the presentation. 
The first build will take a while... the Latex image is over 2GB. Once that container is downloaded and in your local image repo, builds will go faster.

The `statefulapp` and `simpleapp` directories contain gradlew files... so generating their jar artifacts will be easy. 
Just be aware that you also need to package them in Docker containers, and publish those docker containers to your Kubernetes cluster's image repo.
Dockerfiles provided. See stuff in the `demo-script` directory to get an idea of how to package these apps as Docker containers and push them to minikube's image repo (if you're using minikube).

The `demo` directory contains a helm chart. So, if you want to install it, you'll need helm installed plus a Kubernetes cluster (try minikube).

The `demo-script` directory contains scripts numbered in the order I run them when giving the presentation. It's a good place to look to make sure you do things in the right order.

