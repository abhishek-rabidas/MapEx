package abhishek.mapex.api.tracking.dto;

import abhishek.mapex.api.message.dao.Message;
import abhishek.mapex.api.message.dto.MessageResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TagExpenseHistoryResponse {
    private String tag;
    private double totalSpent;
    private int usageTimes;
    private double mostExpensiveAmount;
    private String mostExpensiveDate;
    private List<MessageResponse> history;

    public TagExpenseHistoryResponse(Message message) {
        this.tag = message.getTag().getName();
        this.totalSpent = message.getTag().getTotalSpend();
        this.usageTimes = message.getTag().getUseCount();
        this.history = message.getTag().getMessages().stream().map(MessageResponse::new).toList();
    }
}
