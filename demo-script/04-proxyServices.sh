#!/usr/bin/env bash
set -eo pipefail

minikube service statelessapp-loadbalancer
minikube service statefulapp-loadbalancer

