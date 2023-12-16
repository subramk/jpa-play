package com.jpa.play;

import com.jpa.play.persistence.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()

//@EnableJpaRepositories("com.jpa.play.persistence.repository")

// If you turn OFF  the EnableJpaRepositories, then @WebMvcTest is turning off JPA and hence it will NOT ATTEMPT TO
// load your @Entity Classes , but if you TURN ON @EnableJpaRepositories, then it will try to load the Entity Classes
// and fail stating that it is not able to find a "Entity Manager" - See PhilWebb comment dated Sept 8,2016 here
// https://github.com/spring-projects/spring-boot/issues/6844

@EnableConfigurationProperties({AppProperties.class})
@EntityScan
public class JpaPlayApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JpaPlayApplication.class, args);
	}
}