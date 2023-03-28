package ru.tinkoff.edu.java.scrapper.configuration.Response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tinkoff.edu.java.scrapper.configuration.DTO.Author;
import ru.tinkoff.edu.java.scrapper.configuration.DTO.Commit;

public class CommitResponse {

    private String sha;

    private Author author;

    private Commit commit;

    @JsonCreator
    public CommitResponse(@JsonProperty("sha") String sha,
                          @JsonProperty("commit") Commit commit,
                          @JsonProperty("author") Author author) {
        this.sha = sha;
        this.commit = commit;
        this.author = author;
    }

    // getters and setters
}
