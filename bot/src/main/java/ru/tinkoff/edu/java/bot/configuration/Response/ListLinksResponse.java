package ru.tinkoff.edu.java.bot.configuration.Response;

import java.util.List;

public class ListLinksResponse {

    private List<String> links;

    public ListLinksResponse(List<String> links) {
        this.links = links;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
