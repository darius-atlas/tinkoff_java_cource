package ru.tinkoff.edu.java.bot.configuration.Request;

public class AddLinkRequest {
    private String url;
    private String description;

    public AddLinkRequest(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}

