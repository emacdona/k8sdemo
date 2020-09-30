#!/usr/bin/env bash
set -eo pipefail

trap "kill 0" EXIT

minikube service statelessapp-loadbalancer &
minikube service statefulapp-loadbalancer &

wait
