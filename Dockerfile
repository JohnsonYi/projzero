FROM ubuntu:trusty

MAINTAINER Cheng Li Yi "yichengli@vip.qq.com"

# Update repo index
RUN apt-get update
RUN echo 'debconf debconf/frontend select Noninteractive' | debconf-set-selections

# Install add-apt-repository
RUN apt-get install software-properties-common -y

# Add webupd8team java ppa repo
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt-get update

# Install Oracle JDK 8
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install oracle-java8-installer -y

# Set up the Oracle JDK 8 environment variables
RUN apt-get install oracle-java8-set-default -y

# Install curl
RUN apt-get install curl -y

# Copy
ADD target/projzero-1.0-SNAPSHOT-jar-with-dependencies.jar /projzero/projzero-1.0.jar

# Expose ports.
EXPOSE 8080

# Specify workdir
WORKDIR /projzero

# Define default entrypoint
ENTRYPOINT ["java", "-jar", "projzero-1.0.jar"]
