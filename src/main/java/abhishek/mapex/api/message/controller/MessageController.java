package abhishek.mapex.api.message.controller;

import abhishek.mapex.api.message.dto.MessageRequest;
import abhishek.mapex.api.message.service.ExpenseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    private ExpenseMessageService service;

    @PostMapping
    public ResponseEntity<String> saveMessage(@RequestBody List<MessageRequest> request) {
        service.saveMessage(request);
        return ResponseEntity.ok("Message Saved Successfully");
    }

    @GetMapping
    public ResponseEntity<?> seeAllMessages() {
        return ResponseEntity.ok(service.getAllMessages());
    }

}
