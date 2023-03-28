package ru.tinkoff.edu.java.scrapper.configuration.Response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class QuestionResponse {

    private long questionId;

    private String title;

    private String body;

    private OffsetDateTime creationDate;

    @JsonCreator
    public QuestionResponse(@JsonProperty("question_id") long questionId,
                            @JsonProperty("title") String title,
                            @JsonProperty("body") String body,
                            @JsonProperty("creation_date") long creationDate) {
        this.questionId = questionId;
        this.title = title;
        this.body = body;
        this.creationDate = OffsetDateTime.ofInstant(Instant.ofEpochSecond(creationDate), ZoneId.systemDefault());
    }

    // getters and setters
}
