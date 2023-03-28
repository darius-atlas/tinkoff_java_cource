package ru.tinkoff.edu.java.bot.configuration.Response;

public class LinkResponse {
    private final String link;

    public LinkResponse(Long id, String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}