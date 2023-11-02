package abhishek.mapex.api.message.dao;

import abhishek.mapex.api.base.dao.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Tag extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private double totalSpend = 0;

    @Column(nullable = true)
    private int useCount = 0;

    @OneToMany(mappedBy = "tag")
    private List<Message> messages;
}
