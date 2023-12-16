package com.jpa.play;

import com.jpa.play.persistence.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories("com.jpa.play.persistence.repository")
@EnableConfigurationProperties({AppProperties.class})
@EntityScan
public class JpaPlayApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JpaPlayApplication.class, args);
	}
}