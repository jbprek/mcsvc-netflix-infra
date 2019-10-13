package com.foo.mcsvc.infra.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaServer
@EnableConfigurationProperties
@Slf4j
public class ServiceRegistryApplication {




    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }

}
