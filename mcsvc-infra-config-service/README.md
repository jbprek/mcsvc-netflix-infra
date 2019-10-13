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
    
    - Symmetric encryption key : CONFIG_SERVICE_ENCRYPT_KEY
    - Eureka Host (Default localhost) : MCSVC_DISCOVERY_HOST
    - Eureka Port ( Default 8761): DISCOVERY_PORT
    - Git Repository URL : MCSVC_CONFIG_GIT_URL
    - Git Repository username: MCSVC_CONFIG_GIT_USERNAME
    - Git Repository password: MCSVC_CONFIG_GIT_PASSWORD
    
    
#### Example environment vars
```
CONFIG_SERVICE_ENCRYPT_KEY='[zog3[qTfUZ1;Ib'

echo $CONFIG_SERVICE_ENCRYPT_KEY
```
### Standalone

```
mvn spring-boot:run -Dencrypt.key="$CONFIG_SERVICE_ENCRYPT_KEY" -Dspring.cloud.config.server.git.uri="$MCSVC_CONFIG_GIT_URL" -Dspring.cloud.config.server.git.username="$MCSVC_CONFIG_GIT_USERNAME" -Dspring.cloud.config.server.git.password="$MCSVC_CONFIG_GIT_PASSWORD"
    
```


### Docker Build & Container creation, Initial run
```
mvn compile jib:dockerBuild -Dimage=frx-mcsvc-infra-config-service

docker run --name mcsvc-infra-config-service -d -p8888:8888  -e CONFIG_SERVICE_ENCRYPT_KEY -e MCSVC_CONFIG_GIT_URL -e MCSVC_CONFIG_GIT_USERNAME -e MCSVC_CONFIG_GIT_PASSWORD frx-mcsvc-infra-config-service
```

### Docker re-run
```
docker run -d  -p8888:8888 mcsvc-infra-frx-eureka-service -Dencrypt.key="$CONFIG_SERVICE_ENCRYPT_KEY" -Dspring.cloud.config.server.git.uri="$MCSVC_CONFIG_GIT_URL" -Dspring.cloud.config.server.git.username="$MCSVC_CONFIG_GIT_USERNAME" -Dspring.cloud.config.server.git.password="$MCSVC_CONFIG_GIT_PASSWORD"
```


###Asymmetric Encryption keystore TODO
mvn spring-boot:run \
    -Dencrypt.keystore.password="$KEY_STORE_KEYPASS" \
    -Dencrypt.keystore.alias="$KEY_STORE_ALIAS" \
    -Dencrypt.keystore.secret="$KEY_STORE_STOREPASS" 