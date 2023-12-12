package com.jpa.play;

import com.jpa.play.persistence.config.AppProperties;
import com.jpa.play.persistence.repository.UserJpaRepository;
import org.hibernate.dialect.MySQLServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // exclude to be removed once Datasource is added.
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories("com.jpa.play.persistence.repository")
@EnableConfigurationProperties({AppProperties.class})
@ComponentScan("com.jpa.play.service")
@EntityScan
public class JpaPlayApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JpaPlayApplication.class, args);
	}

}