FROM ubuntu:latest
LABEL authors="ming"

ENTRYPOINT ["top", "-b"]