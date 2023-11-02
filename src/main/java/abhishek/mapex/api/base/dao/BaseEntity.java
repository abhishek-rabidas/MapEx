package abhishek.mapex.api.base.dao;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {

    @Column(nullable = false, length = 64)
    private String uid;

    private Date createdOn;

    @PrePersist
    private void preCreate() {
        this.uid = UUID.randomUUID().toString();
        this.createdOn = new Date();
    }

}
