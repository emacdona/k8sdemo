This isn't really intended for public consumption yet, but with some determination, you might just get it to work!

In the `presentation` directory, there is a Makefile that will build the presentation. You'll need Docker installed. The Makefile builds docker images for both Dia and Latex, which are needed to build the presentation. 
The first build will take a while... the Latex image is over 2GB.

The `statefulapp` and `simpleapp` directories contain gradlew files... so they're easy.

The `demo` directory contains a helm chart. So, if you want to install it, you'll need a Kubernetes cluster. Try minikube.

The `demo-script` directory contains scripts numbered in the order I run them when giving the presentation. It's a good place to look to make sure you do things in the right order.

