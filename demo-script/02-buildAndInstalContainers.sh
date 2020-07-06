#!/usr/bin/env bash
set -eo pipefail

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

(  cd ${DIR}/../simpleapp && \
   ./gradlew clean build && \
   docker build --build-arg JAR_FILE=build/libs/simpleapp-0.0.1-SNAPSHOT.jar -t kubedemo/statelessapp .\
)

(  cd ${DIR}/../statefulapp && \
   ./gradlew clean build && \
   docker build --build-arg JAR_FILE=build/libs/statefulapp-0.0.1-SNAPSHOT.jar -t kubedemo/statefulapp .
)

