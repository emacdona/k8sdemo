#!/usr/bin/env bash
set -eo pipefail

minikube dashboard > dashboard.out 2>&1 &
