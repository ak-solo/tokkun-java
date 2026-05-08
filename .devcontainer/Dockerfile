FROM eclipse-temurin:21-jdk

# Gradle のインストール
ARG GRADLE_VERSION=8.7
RUN apt-get update && apt-get install -y unzip curl wget && \
    wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -O /tmp/gradle.zip && \
    unzip -q /tmp/gradle.zip -d /opt && \
    ln -s /opt/gradle-${GRADLE_VERSION}/bin/gradle /usr/local/bin/gradle && \
    rm /tmp/gradle.zip && \
    apt-get clean

WORKDIR /workspace
