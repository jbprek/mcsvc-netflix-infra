package org.bagab.mcsvc.infra.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServiceApplication.class, args);
    }

}
