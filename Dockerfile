FROM gradle:8.7-jdk21

WORKDIR /

COPY gradlew .
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle/ gradle/

RUN chmod +x gradlew

COPY src/ src/

RUN ./gradlew build installDist
