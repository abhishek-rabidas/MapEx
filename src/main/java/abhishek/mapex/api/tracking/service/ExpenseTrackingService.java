package abhishek.mapex.api.tracking.service;

import abhishek.mapex.api.message.dao.Tag;
import abhishek.mapex.api.message.jpa.MessageRepository;
import abhishek.mapex.api.message.jpa.TagRepository;
import abhishek.mapex.api.tracking.dto.TagExpenseHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseTrackingService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<TagExpenseHistoryResponse> seeExpensesByTags(@RequestBody List<String> requestTags) {

        List<Tag> tags = tagRepository.findAllByNameIn(requestTags);

        if (tags == null) {
            throw new RuntimeException("No expenses found");
        }

        List<TagExpenseHistoryResponse> responses = new ArrayList<>();

        for (Tag tag : tags) {
            TagExpenseHistoryResponse tagExpenseHistoryResponse = new TagExpenseHistoryResponse(tag);
            responses.add(tagExpenseHistoryResponse);
        }

        return responses;
    }
}
