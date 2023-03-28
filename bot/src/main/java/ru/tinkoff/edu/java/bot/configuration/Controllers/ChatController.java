package ru.tinkoff.edu.java.bot.configuration.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.bot.configuration.DTO.Link;
import ru.tinkoff.edu.java.bot.configuration.Request.AddLinkRequest;
import ru.tinkoff.edu.java.bot.configuration.Request.RemoveLinkRequest;
import ru.tinkoff.edu.java.bot.configuration.Response.ApiErrorResponse;
import ru.tinkoff.edu.java.bot.configuration.Response.LinkResponse;
import ru.tinkoff.edu.java.bot.configuration.Response.ListLinksResponse;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class ChatController {

    private Set<Long> registeredChatIds = new HashSet<>(); // Keeps track of registered chat IDs
    private Map<Long, List<String>> trackedLinks = new HashMap<>(); // Keeps track of tracked links per chat ID

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Object> registerChat(@PathVariable Long id) {
        // Register the chat ID
        // Stub implementation for now
        registeredChatIds.add(id);
        System.out.println("Registered chat ID: " + id);

        // Return success response
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<Object> deleteChat(@PathVariable Long id) {
        // Delete the chat ID if it is registered
        // Stub implementation for now
        if (registeredChatIds.contains(id)) {
            registeredChatIds.remove(id);
            System.out.println("Deleted chat ID: " + id);

            // Remove tracked links for the deleted chat ID
            trackedLinks.remove(id);

            // Return success response
            return ResponseEntity.ok().build();
        } else {
            // Return error response if chat ID not found
            ApiErrorResponse errorResponse = new ApiErrorResponse("Chat ID not found", "404", "NotFoundException", "Chat ID " + id + " not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/tg-chat/{id}/links")
    public ResponseEntity<Object> addTrackedLink(@PathVariable Long id, @RequestBody AddLinkRequest addLinkRequest) {
        // Check if chat ID is registered
        if (!registeredChatIds.contains(id)) {
            ApiErrorResponse errorResponse = new ApiErrorResponse("Chat ID not found", "404", "NotFoundException", "Chat ID " + id + " not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        // Add the tracked link for the chat ID
        trackedLinks.computeIfAbsent(id, k -> new ArrayList<>()).add(addLinkRequest.getUrl());
        System.out.println("Tracked link added for chat ID " + id + ": " + addLinkRequest.getUrl());

        // Return success response with the added link
        //LinkResponse linkResponse = new LinkResponse(link.getId(), addLinkRequest.getUrl());
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/tg-chat/{id}/links")
    public ResponseEntity<Object> getAllTrackedLinks(@PathVariable Long id) {
        // Check if chat ID is registered
        if (!registeredChatIds.contains(id)) {
            ApiErrorResponse errorResponse = new ApiErrorResponse("Chat ID not found", "404", "NotFoundException", "Chat ID " + id + " not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        // Get tracked links for the chat ID
        List<String> links = trackedLinks.getOrDefault(id, Collections.emptyList());

        // Return success response with the tracked links
        ListLinksResponse listLinksResponse = new ListLinksResponse(links);
        return ResponseEntity.ok().body(listLinksResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        // Handle exceptions and return error response
        // Stub implementation for now
        ApiErrorResponse errorResponse = new ApiErrorResponse("Error processing request", "500", ex.getClass().getSimpleName(), ex.getMessage(), Arrays.asList(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


    @DeleteMapping
    public ResponseEntity<LinkResponse> deleteLink(
            @RequestHeader("Tg-Chat-Id") Long chatId,
            @RequestBody RemoveLinkRequest request) {

        if (request == null || request.getUrl() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(null);
    }


    // todo: crete method
    @GetMapping
    public ResponseEntity<ListLinksResponse> listLinks() {
        //List<Link> links = linkService.getAllLinks();
        List<Link> links = null;
                List<LinkResponse> linkResponses = links.stream()
                .map(link -> new LinkResponse(link.getId(), link.getUrl()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(null);
    }

    // todo: crete method
    @PostMapping
    public ResponseEntity<LinkResponse> addLink(@RequestBody AddLinkRequest request, @RequestHeader("Tg-Chat-Id") Long chatId) {
        //Link link = linkService.addLink(request.getLink(), chatId);
        // todo: add linkService : addLink
        Link link = null;
        LinkResponse response = new LinkResponse(link.getId(), link.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // todo: crete method
    @DeleteMapping
    public ResponseEntity<LinkResponse> removeLink(@RequestBody RemoveLinkRequest request, @RequestHeader("Tg-Chat-Id") Long chatId) {
        //Link link = linkService.removeLink(request.getLink(), chatId);
        Link link = null;
        LinkResponse response = new LinkResponse(link.getId(), link.getUrl());
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException e) {
        ApiErrorResponse response = new ApiErrorResponse(e.getClass().getSimpleName(),
                e.getMessage(), Arrays.asList(e.getStackTrace()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}


