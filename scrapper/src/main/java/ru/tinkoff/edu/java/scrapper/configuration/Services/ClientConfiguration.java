package ru.tinkoff.edu.java.scrapper.configuration.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
public class ClientConfiguration {

    // todo: complate the gitHubWebClient method
    @Bean
    public WebClient gitHubWebClient() {
        return (WebClient) WebClient.builder("https://api.github.com");
    }

    // todo: complate the stackOverflowWebClient method
    @Bean
    public WebClient stackOverflowWebClient() {
        return (WebClient) WebClient.builder("https://api.github.com");
    }
}



