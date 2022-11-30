FROM azul/zulu-openjdk:17

ARG JARPREFIX=4rt1f4ct

RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

WORKDIR /app

COPY target/${JARPREFIX}-*.jar app.jar

CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8080
