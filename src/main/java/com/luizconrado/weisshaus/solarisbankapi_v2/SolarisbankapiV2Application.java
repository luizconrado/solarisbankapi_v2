package com.luizconrado.weisshaus.solarisbankapi_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SolarisbankapiV2Application {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(SolarisbankapiV2Application.class, args)) {

            System.out.println("Application Started...");


            System.out.println("Application Closing...");

//         https://www.baeldung.com/spring-boot-shutdown
//         ctx.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            e.printStackTrace();
            Throwable[] suppressedExceptions = e.getSuppressed();
            for (Throwable suppressed : suppressedExceptions) {
                System.out.println(suppressed.toString());
                System.out.println(suppressed.getMessage());
            }

        }


    }

}
