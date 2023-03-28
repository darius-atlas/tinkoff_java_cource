package ru.tinkoff.edu.java.bot.configuration;

public class TelegramServiceBuilder {
    private String botToken;

    public TelegramServiceBuilder setBotToken(String botToken) {
        this.botToken = botToken;
        return this;
    }

    public TelegramService createTelegramService() {
        return new TelegramService(botToken);
    }
}