package ru.tinkoff.edu.java.parser.responses;


public record StackOverflowResponse(Integer questionId) implements Response {
    public StackOverflowResponse {
        if (questionId == null) {
            throw new NullPointerException("Question ID cannot be null");
        }
    }
}
