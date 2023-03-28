package ru.tinkoff.edu.java.scrapper.configuration.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Author {

    private String name;

    private String email;

    private OffsetDateTime date;

    @JsonCreator
    public Author(@JsonProperty("name") String name,
                  @JsonProperty("email") String email,
                  @JsonProperty("date") String dateStr) {
        this.name = name;
        this.email = email;
        this.date = OffsetDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
    }


    public OffsetDateTime getDate() {
        return this.date;
    }
}
