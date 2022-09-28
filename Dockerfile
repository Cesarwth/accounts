FROM openjdk:17

ADD target/cuentas.jar cuentas.jar

ENTRYPOINT ["java", "-jar", "cuentas.jar"]