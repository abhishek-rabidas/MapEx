package abhishek.mapex.api.message.dto;

import abhishek.mapex.api.message.dao.Message;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;

@Getter
@Setter
public class MessageResponse {
    private String date;
    private String time;
    private double amount;
    private String description;

    public MessageResponse(Message message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        this.date = dateFormat.format(message.getCreatedOn());
        this.time = timeFormat.format(message.getCreatedOn());
        this.amount = message.getAmount();
        this.description = message.getDescription();
    }
}
