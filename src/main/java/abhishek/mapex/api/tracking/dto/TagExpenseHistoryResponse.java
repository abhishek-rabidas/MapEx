package abhishek.mapex.api.tracking.dto;

import abhishek.mapex.api.message.dao.Message;
import abhishek.mapex.api.message.dao.Tag;
import abhishek.mapex.api.message.dto.MessageResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TagExpenseHistoryResponse {
    private String tag;
    private double totalSpent;
    private int usageTimes;
    private double mostExpensiveAmount;
    private String mostExpensiveDate;
    private List<MessageResponse> history;

    public TagExpenseHistoryResponse(Tag tag) {
        this.tag = tag.getName();
        this.totalSpent = tag.getTotalSpend();
        this.usageTimes = tag.getUseCount();
        this.history = tag.getMessages().stream().map(MessageResponse::new).toList();
    }
}
