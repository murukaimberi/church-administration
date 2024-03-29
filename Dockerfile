FROM eclipse-temurin:17 as builder
WORKDIR workspace
COPY target/*.jar church-admin.jar
RUN java -Djarmode=layertools -jar church-admin.jar extract

FROM eclipse-temurin:17
WORKDIR workspace
COPY --from=builder workspace/dependencies/ ./
COPY --from=builder workspace/spring-boot-loader/ ./
COPY --from=builder workspace/snapshot-dependencies/ ./
COPY --from=builder workspace/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]