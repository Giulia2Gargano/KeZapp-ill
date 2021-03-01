package it.sirfin.KeZappillserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"it.sirfin.KeZappillserver"})
@EnableJpaRepositories(basePackages = {"it.sirfin.KeZappillserver.repository"})
@EntityScan(basePackages = {"it.sirfin.KeZappillserver.model"})
public class KeZappIllServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeZappIllServerApplication.class, args);
    }

}
