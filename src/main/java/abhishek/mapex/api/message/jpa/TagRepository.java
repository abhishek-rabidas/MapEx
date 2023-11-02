package abhishek.mapex.api.message.jpa;

import abhishek.mapex.api.message.dao.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    int countAllByNameIgnoreCase(String name);

    Tag findByNameIgnoreCase(String name);

    List<Tag> findAllByNameIn(List<String> names);
}
