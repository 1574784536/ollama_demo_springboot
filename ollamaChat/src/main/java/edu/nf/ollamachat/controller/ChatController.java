package edu.nf.ollamachat.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YXD
 * @date 2024/8/26
 */
@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    private final OllamaChatModel ollamaChatModel;

    public ChatController(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @PostMapping("/chat")
    public Map<String, Object> chat(@RequestBody String message) {
        String call = ollamaChatModel.call(message);
        Map<String, Object> response = new HashMap<>();
        response.put("message", call);
        return response;
    }
}
