#!/usr/bin/env bash
set -eo pipefail

# see: https://stackoverflow.com/questions/42564058/how-to-use-local-docker-images-with-minikube

if [ "$0" = "$BASH_SOURCE" ]; then
   echo "This script needs to be sourced." 1>&2;
else
   eval $(minikube docker-env)
fi;


