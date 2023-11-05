package abhishek.mapex.api.tracking.controller;

import abhishek.mapex.api.tracking.dto.DateExpenseHistoryResponse;
import abhishek.mapex.api.tracking.dto.TagExpenseHistoryResponse;
import abhishek.mapex.api.tracking.service.ExpenseTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracking")
public class ExpenseTrackingController {

    @Autowired
    private ExpenseTrackingService service;

    @PostMapping("/tags")
    public ResponseEntity<List<TagExpenseHistoryResponse>> seeExpensesByTags(@RequestBody List<String> tags) {
        return ResponseEntity.ok(service.seeExpensesByTags(tags));
    }

    @PostMapping("/date")
    public ResponseEntity<DateExpenseHistoryResponse> seeExpensesByDate(@RequestBody String date) {
        return ResponseEntity.ok(service.seeExpensesByDate(date));
    }
}
