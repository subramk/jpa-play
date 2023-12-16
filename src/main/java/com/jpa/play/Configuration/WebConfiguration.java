package com.jpa.play.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EntityManagerConfiguration.class}) // needs EntityManager
public class WebConfiguration {

    WebConfiguration(){
    }
}
