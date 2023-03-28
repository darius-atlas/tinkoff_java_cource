package ru.tinkoff.edu.java.bot.configuration.Request;

public class RemoveLinkRequest {
    private String url;

    public RemoveLinkRequest() {
    }

    public RemoveLinkRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

