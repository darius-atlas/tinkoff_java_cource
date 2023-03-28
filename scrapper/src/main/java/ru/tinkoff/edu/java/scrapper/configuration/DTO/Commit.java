package ru.tinkoff.edu.java.scrapper.configuration.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class Commit {

    private String message;

    private OffsetDateTime authorDate;

    @JsonCreator
    public Commit(@JsonProperty("message") String message,
                  @JsonProperty("author") Author author) {
        this.message = message;
        this.authorDate = author != null ? author.getDate() : null;
    }
}
