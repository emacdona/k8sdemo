#!/usr/bin/env bash
set -eo pipefail

if [ "$0" = "$BASH_SOURCE" ]; then
   echo "This script needs to be sourced." 1>&2;
else
   eval $(minikube docker-env)
fi;


