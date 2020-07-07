#!/usr/bin/env bash
set -eo pipefail

kubectl scale statefulsets statefulapp --replicas=3
