package abhishek.mapex.api.message.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MessageRequest {
    private double amount;
    private String tag;
}
