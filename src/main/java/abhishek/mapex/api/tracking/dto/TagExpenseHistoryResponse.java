package abhishek.mapex.api.tracking.dto;

import abhishek.mapex.api.message.dao.Tag;
import abhishek.mapex.api.message.dto.MessageResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.tag = tag.getName();
        this.totalSpent = tag.getTotalSpend();
        this.usageTimes = tag.getUseCount();

        AtomicReference<Double> maxAmount = new AtomicReference<>((double) 0);
        AtomicReference<String> mostExpensiveDate = new AtomicReference<>("");
        this.history = tag.getMessages().stream().map(message -> {
            if (message.getAmount() > maxAmount.get()) {
                maxAmount.set(message.getAmount());
                mostExpensiveDate.set(dateFormat.format(message.getCreatedOn()));
            }
            return new MessageResponse(message);
        }).toList();

        this.mostExpensiveAmount = maxAmount.get();
        this.mostExpensiveDate = mostExpensiveDate.get();
    }
}
