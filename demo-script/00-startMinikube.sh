#!/usr/bin/env bash
set -eo pipefail

minikube delete

# sudo brew services start socket_vmnet
#minikube start --network=socket_vmnet

minikube start --driver=docker
