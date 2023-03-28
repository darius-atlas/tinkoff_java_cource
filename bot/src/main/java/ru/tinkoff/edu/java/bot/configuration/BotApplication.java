package ru.tinkoff.edu.java.bot.configuration;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}


//@Component
//public class Bot {
//    private static final String COMMAND = "/start";
//
//    private final TelegramService telegramService;
//    private final RabbitTemplate rabbitTemplate;
//
//    private LinkParser linkParserService = new LinkParserApplication();
//
//    public Bot(TelegramService telegramService, RabbitTemplate rabbitTemplate) {
//        this.telegramService = telegramService;
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void handleMessage(String message, Long chatId) throws IOException {
//        if (message.startsWith(COMMAND)) {
//            String response = "Hello, Your links is sended to the quote and will added to the parce!";
//
//            telegramService.sendMessage(chatId, response);
//        } else {
//            List<String> urls = extractUrls(message);
//
//            if (!urls.isEmpty()) {
//                sendUrlsToRabbitMQ(urls);
//            }
//        }
//    }
//
//    private List<String> extractUrls(String message) {
//        String result = parseLink(message);
//        return Collections.singletonList(result);
//    }
//
//    private void sendUrlsToRabbitMQ(List<String> urls) {
//        rabbitTemplate.convertAndSend("urls-queue", urls);
//    }
//}