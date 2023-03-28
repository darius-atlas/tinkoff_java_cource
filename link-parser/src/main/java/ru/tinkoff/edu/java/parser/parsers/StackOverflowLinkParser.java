package ru.tinkoff.edu.java.parser.parsers;

import java.net.URI;
import java.net.URISyntaxException;

import ru.tinkoff.edu.java.parser.responses.Response;
import ru.tinkoff.edu.java.parser.responses.StackOverflowResponse;


public record StackOverflowLinkParser() implements LinkParser {
    @Override
    public Response parseLink(String link) {
        URI uri;

        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            return null;
        }

        if (!uri.getHost().equals("stackoverflow.com")) {
            return null;
        }

        String[] segments = uri.getPath().split("/");

        if (segments.length != 3 || !segments[1].equals("questions")) {
            return null;
        }

        try {
            int questionId = Integer.parseInt(segments[2]);
            return new StackOverflowResponse(questionId);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
