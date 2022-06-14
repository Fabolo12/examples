package com;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.StringWriter;

@EnableJpaRepositories("com.repositories")
@EntityScan("com.models")
@SpringBootApplication
@Log4j2
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
