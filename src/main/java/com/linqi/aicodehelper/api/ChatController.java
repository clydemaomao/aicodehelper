package com.linqi.aicodehelper.api;

import com.linqi.aicodehelper.ai.AicodehelperService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    @Resource
    private AicodehelperService aiCodeHelperService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        if (request == null || request.message() == null || request.message().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        String reply = aiCodeHelperService.chat(request.message());
        return ResponseEntity.ok(new ChatResponse(reply));
    }

    public record ChatRequest(String message) {
    }

    public record ChatResponse(String reply) {
    }
}
