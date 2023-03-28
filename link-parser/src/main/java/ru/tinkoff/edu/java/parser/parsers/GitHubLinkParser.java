package ru.tinkoff.edu.java.parser.parsers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import ru.tinkoff.edu.java.parser.responses.GitHubResponse;
import ru.tinkoff.edu.java.parser.responses.Response;


public final record GitHubLinkParser() implements LinkParser {
    @Override
    public Response parseLink(String link) {
        URI uri;

        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            return null;
        }

        if (!uri.getHost().equals("github.com")) {
            return null;
        }


        Optional<String> owner = Optional.ofNullable(uri.getPath())
                .map(path -> path.split("/"))
                .filter(parts -> parts.length >= 3)
                .map(parts -> parts[1])
                .filter(part -> !part.isEmpty());

        Optional<String> repository = Optional.ofNullable(uri.getPath())
                .map(path -> path.split("/"))
                .filter(parts -> parts.length >= 3)
                .map(parts -> parts[2])
                .filter(part -> !part.isEmpty());


        if (owner.isPresent() && repository.isPresent()) {
            return new GitHubResponse(owner.get(), repository.get());
        } else {
            return null;
        }
    }
}
