FROM maven:3.8.1-openjdk-16

RUN mkdir -p /deploy/application

VOLUME ["/deploy/application"]

WORKDIR /deploy/application

ADD . .

ENTRYPOINT ["mvn","clean","package"]