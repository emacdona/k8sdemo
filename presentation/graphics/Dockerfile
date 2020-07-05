FROM ubuntu@sha256:747d2dbbaaee995098c9792d99bd333c6783ce56150d1b11e333bbceed5c54d7

RUN apt-get update && apt-get install -y dia

WORKDIR /workdir

ENTRYPOINT ["dia"]

CMD ["--version"]
