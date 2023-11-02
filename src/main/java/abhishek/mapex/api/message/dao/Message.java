package abhishek.mapex.api.message.dao;

import abhishek.mapex.api.base.dao.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends BaseEntity {

    private double amount;

    private String description;

    @ManyToOne
    private Tag tag;
}
