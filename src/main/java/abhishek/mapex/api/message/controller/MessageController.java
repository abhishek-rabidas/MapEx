package abhishek.mapex.api.message.controller;

import abhishek.mapex.api.message.dto.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @PostMapping
    public ResponseEntity<?> saveMessage(@RequestBody List<MessageRequest> request) {
        return null;
    }

    @GetMapping
    public ResponseEntity<?> seeAllMessages() {
        return null;
    }

}
