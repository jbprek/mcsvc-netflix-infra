package com.foo.mcsvc.infra.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class McsvcInfraAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(McsvcInfraAdminServiceApplication.class, args);
    }

}
