#!/usr/bin/env bash
set -eo pipefail

(  cd simpleapp && \
   ./gradlew clean build && \
   docker build --build-arg JAR_FILE=build/libs/simpleapp-0.0.1-SNAPSHOT.jar -t kubedemo/statelessapp .\
)

(  cd statefulapp && \
   ./gradlew clean build && \
   docker build --build-arg JAR_FILE=build/libs/statefulapp-0.0.1-SNAPSHOT.jar -t kubedemo/statefulapp .
)

