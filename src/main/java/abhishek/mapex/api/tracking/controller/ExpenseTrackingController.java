package abhishek.mapex.api.tracking.controller;

import abhishek.mapex.api.tracking.dto.TagExpenseHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tracking")
public class ExpenseTrackingController {

    @GetMapping("/tags")
    public ResponseEntity<TagExpenseHistoryResponse> seeExpensesByTags() {
        return null;
    }


}
