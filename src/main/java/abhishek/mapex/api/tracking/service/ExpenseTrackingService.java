package abhishek.mapex.api.tracking.service;

import abhishek.mapex.api.message.dao.Message;
import abhishek.mapex.api.message.dao.QMessage;
import abhishek.mapex.api.message.dao.Tag;
import abhishek.mapex.api.message.dto.MessageResponse;
import abhishek.mapex.api.message.jpa.MessageRepository;
import abhishek.mapex.api.message.jpa.TagRepository;
import abhishek.mapex.api.tracking.dto.DateExpenseHistoryResponse;
import abhishek.mapex.api.tracking.dto.TagExpenseHistoryResponse;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExpenseTrackingService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EntityManager entityManager;

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

    public DateExpenseHistoryResponse seeExpensesByDate(String date) {

        List<Integer> dateParsed = Arrays.stream(date.split("-")).map(Integer::valueOf).toList();

        QMessage message = new QMessage("message");
        JPAQuery<Message> query = new JPAQuery<>(entityManager);

        List<Message> messages = query.from(message).where(message.createdOn.dayOfMonth().eq(dateParsed.get(0))
                .and(message.createdOn.month().eq(dateParsed.get(1)))
                .and(message.createdOn.year().eq(dateParsed.get(2)))).fetch();

        if (messages == null) {
            throw new RuntimeException("Not found");
        }

        query = new JPAQuery<>(entityManager);

        double totalAmount = query.select(message.amount.sum()).from(message).where(message.createdOn.dayOfMonth().eq(dateParsed.get(0))
                .and(message.createdOn.month().eq(dateParsed.get(1)))
                .and(message.createdOn.year().eq(dateParsed.get(2)))).fetchOne();

        DateExpenseHistoryResponse dateExpenseHistoryResponse = new DateExpenseHistoryResponse();

        dateExpenseHistoryResponse.setTotalAmount(totalAmount);
        dateExpenseHistoryResponse.setNumOfPayments(messages.size());
        dateExpenseHistoryResponse.setHistory(messages.stream().map(MessageResponse::new).toList());

        return dateExpenseHistoryResponse;
    }
}
