package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class TelegramService {
    private static final String TELEGRAM_BASE_URL = "https://api.telegram.org/bot";

    private String botToken = null;

    public TelegramService(@Value("${telegram.bot-token}")String botToken) {
        this.botToken = this.botToken;
    }

    public void sendMessage(Long chatId, String message) throws IOException, MalformedURLException {
        URL url = new URL(TELEGRAM_BASE_URL + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + message);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
    }
}
