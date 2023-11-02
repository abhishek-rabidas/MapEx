package abhishek.mapex.api.message.jpa;

import abhishek.mapex.api.message.dao.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
