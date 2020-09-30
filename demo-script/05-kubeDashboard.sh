#!/usr/bin/env bash
set -eo pipefail

trap "kill 0" EXIT

minikube dashboard 2>&1 | tee dashboard.out &

wait
