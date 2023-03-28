package ru.tinkoff.edu.java.parser.responses;


/**
 * A marker interface for response objects returned by the link parsers.
 * Implementations include {@link GitHubResponse} and {@link StackOverflowResponse}.
 */
public sealed interface Response permits GitHubResponse, StackOverflowResponse {}
