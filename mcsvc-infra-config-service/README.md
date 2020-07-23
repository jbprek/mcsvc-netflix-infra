mcsvc-infra-config-service
==========================

Spring Boot Cloud Config Server Implementation



Reference documentation
-----------------------
[Spring Cloud Config](https://spring.io/projects/spring-cloud-config)

[Spring Cloud Config Server Section](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html#_spring_cloud_config_server)

Build & Run
-----------

### Create a GIT repository

### Expose symetric key

1. Need to set the following environment vars
    
    - Eureka Host (Default localhost) : EUREKA_HOST
    - Eureka Host (Default http://localhost:8761/eureka) : EUREKA_URL
    - Symmetric encryption key : CONFIG_SERVICE_ENCRYPT_KEY
    - Git Repository URL     : CONFIG_GIT_URL
    - Git Repository username: CONFIG_GIT_USERNAME
    - Git Repository password: CONFIG_GIT_PASSWORD
    
    
#### Example environment vars
```
CONFIG_SERVICE_ENCRYPT_KEY='[zog3[qTfUZ1;Ib'

echo $CONFIG_SERVICE_ENCRYPT_KEY
```
### Standalone

```
mvn spring-boot:run -Dencrypt.key="$CONFIG_SERVICE_ENCRYPT_KEY" -Dspring.cloud.config.server.git.uri="$MCSVC_CONFIG_GIT_URL" -Dspring.cloud.config.server.git.username="$MCSVC_CONFIG_GIT_USERNAME" -Dspring.cloud.config.server.git.password="$MCSVC_CONFIG_GIT_PASSWORD"
    
```


### Docker Build 
```
mvn clean install spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/mcsvc-infra-config-service

docker push jbprek/mcsvc-infra-config-service


```

## Asymetric Keystore

### Keystore creation example
keytool -genkeypair -alias config-server-key -keyalg RSA -dname "CN=Config Server,OU=infra,O=prekezes,L=City,S=State,C=IE" -keypass changeme -keystore config-server.jks -storepass changeme