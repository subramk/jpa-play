package com.jpa.play;

import com.jpa.play.persistence.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class, LiquibaseProperties.class})

public class JpaPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPlayApplication.class, args);
	}

}