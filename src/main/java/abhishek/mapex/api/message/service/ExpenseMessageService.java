package abhishek.mapex.api.message.service;

import abhishek.mapex.api.message.dao.Message;
import abhishek.mapex.api.message.dao.Tag;
import abhishek.mapex.api.message.dto.MessageRequest;
import abhishek.mapex.api.message.dto.MessageResponse;
import abhishek.mapex.api.message.jpa.MessageRepository;
import abhishek.mapex.api.message.jpa.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseMessageService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(List<MessageRequest> request) {
        for (MessageRequest messageRequest : request) {
            Message message = new Message();
            message.setAmount(messageRequest.getAmount());
            message.setDescription(messageRequest.getDescription());
            message.setTag(handleTag(messageRequest.getTag().trim(), messageRequest.getAmount()));
            messageRepository.save(message);
        }
    }

    private Tag handleTag(String keyword, double amount) {
        Tag tag = tagRepository.findByNameIgnoreCase(keyword);

        if (tag == null) {
            tag = new Tag();
            tag.setName(keyword.toUpperCase());
        }

        tag.setTotalSpend(tag.getTotalSpend() + amount);
        tag.setUseCount(tag.getUseCount() + 1);

        return tagRepository.save(tag);
    }

    public List<MessageResponse> getAllMessages() {
        return messageRepository.findAll().stream().map(MessageResponse::new).toList();
    }

}
