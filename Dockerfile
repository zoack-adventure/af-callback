FROM openjdk:8-jdk-alpine

EXPOSE 8080

ENV SPRING_BOOT_USER user
ENV SPRING_BOOT_GROUP user

COPY docker-entrypoint.sh docker-entrypoint.sh

RUN addgroup -S $SPRING_BOOT_USER && adduser -S -g $SPRING_BOOT_GROUP $SPRING_BOOT_USER && \
chmod 555 docker-entrypoint.sh && sh -c 'touch /af-callback.jar'

COPY build/libs/payments-*.jar /af-callback.jar

ENTRYPOINT ["./docker-entrypoint.sh"]