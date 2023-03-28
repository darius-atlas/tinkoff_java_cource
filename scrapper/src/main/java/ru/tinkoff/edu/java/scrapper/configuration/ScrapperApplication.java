package ru.tinkoff.edu.java.scrapper.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * Main application class for the scrapper.
 */
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperApplication {

        public static void main(String[] args) {
                var ctx = SpringApplication.run(ScrapperApplication.class, args);
                var config = ctx.getBean(ApplicationConfig.class);
                if (config != null) {
                        System.out.println(config);
                } else {
                        System.err.println("Failed to get ApplicationConfig from application context");
                }
        }
}
