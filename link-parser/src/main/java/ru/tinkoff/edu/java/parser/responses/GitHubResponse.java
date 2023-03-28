package ru.tinkoff.edu.java.parser.responses;


public record GitHubResponse(String username, String repository) implements Response {
    public GitHubResponse {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        if (repository == null) {
            throw new NullPointerException("Repository cannot be null");
        }
    }
}
