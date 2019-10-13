mcsvc-infra-eureka-service
==============================

Spring Boot cloud Netflix Eureka Implementation



Reference documentation
-----------------------
[Spring Cloud NetFlix](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)

[Service Discovery Eureka Server](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#spring-cloud-eureka-server)


Build & Run
-----------

### Standalone

```
mvn spring-boot:run
```


### Docker Build & Container creation, Initial run
```
mvn compile jib:dockerBuild

docker run --name mcsvc-infra-eureka-service -d -p8761:8761 jbprek/mcsvc-infra-eureka-service:latest
```