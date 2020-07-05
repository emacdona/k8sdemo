#!/usr/bin/env bash
set -eo pipefail

POD_NAME=$(kubectl get pods -l name=confusedapp -o json | jq -r '.items[0].metadata.name')

kubectl exec --stdin --tty statefulapp-0 -- ping statefulapp-0.statefulapp.default.svc.cluster.local
