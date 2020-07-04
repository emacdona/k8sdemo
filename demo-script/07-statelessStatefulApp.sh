#!/usr/bin/env bash
set -eo pipefail

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

kubectl apply -f "${DIR}/confusedapp-deployment.yaml"

minikube service confusedapp-loadbalancer

