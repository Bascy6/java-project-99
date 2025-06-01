FROM gradle:8.7-jdk21

WORKDIR /

COPY / .

RUN chmod +x gradlew

RUN ./gradlew installDist

CMD ./build/install/app/bin/app
