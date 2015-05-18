FROM java:7

MAINTAINER yang.leijun@gmail.com

ENV ARTIFACTORY_VERSION 3.7.0
ENV ARTIFACTORY_HOME /artifactory-${ARTIFACTORY_VERSION}

ADD http://dl.bintray.com/content/jfrog/artifactory/artifactory-${ARTIFACTORY_VERSION}.zip?direct artifactory.zip

RUN unzip artifactory.zip

RUN sed -i -e 's/Xmx2g/Xmx512m/g' artifactory-*/bin/artifactory.default

# Expose the default endpoint
EXPOSE 8081

VOLUME /artifactory-${ARTIFACTORY_VERSION}/data
VOLUME /artifactory-${ARTIFACTORY_VERSION}/logs
VOLUME /artifactory-${ARTIFACTORY_VERSION}/backup
VOLUME /artifactory-${ARTIFACTORY_VERSION}/etc

WORKDIR /artifactory-${ARTIFACTORY_VERSION}

# Run the embedded tomcat container
ENTRYPOINT /artifactory-${ARTIFACTORY_VERSION}/bin/artifactory.sh
