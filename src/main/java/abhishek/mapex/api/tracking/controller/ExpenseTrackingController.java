package abhishek.mapex.api.tracking.controller;

import abhishek.mapex.api.tracking.dto.DateExpenseHistoryResponse;
import abhishek.mapex.api.tracking.dto.TagExpenseHistoryResponse;
import abhishek.mapex.api.tracking.service.ExpenseTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracking")
public class ExpenseTrackingController {

    @Autowired
    private ExpenseTrackingService service;

    @GetMapping("/tags")
    public ResponseEntity<List<TagExpenseHistoryResponse>> seeExpensesByTags(@RequestBody List<String> tags) {
        return ResponseEntity.ok(service.seeExpensesByTags(tags));
    }

    @GetMapping("/date")
    public ResponseEntity<DateExpenseHistoryResponse> seeExpensesByDate(@RequestBody String date) {

    }
}
