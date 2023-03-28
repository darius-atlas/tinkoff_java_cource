package ru.tinkoff.edu.java.bot.configuration.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.configuration.Response.ApiErrorResponse;

@RestController
@RequestMapping("/updates")
public class BotController {

    @PostMapping
    public ResponseEntity<String> processUpdate(@RequestBody LinkUpdate linkUpdate) {
        //TODO: Implement processing of the update

        // Return success response
        return ResponseEntity.ok("Обновление обработано");
    }

    // Define the error response
    private ResponseEntity<ApiErrorResponse> errorResponse(String code, String description, Exception ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setCode(code);
        apiErrorResponse.setDescription(description);
        if (ex != null) {
            apiErrorResponse.setExceptionName(ex.getClass().getName());
            apiErrorResponse.setExceptionMessage(ex.getMessage());
        }
        return ResponseEntity.badRequest().body(apiErrorResponse);
    }
}
