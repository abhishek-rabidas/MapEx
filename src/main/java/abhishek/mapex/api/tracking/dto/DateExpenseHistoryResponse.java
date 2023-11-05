package abhishek.mapex.api.tracking.dto;

import abhishek.mapex.api.message.dto.MessageResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DateExpenseHistoryResponse {
    private List<MessageResponse> history;
    private double totalAmount;
    private int numOfPayments;
}
