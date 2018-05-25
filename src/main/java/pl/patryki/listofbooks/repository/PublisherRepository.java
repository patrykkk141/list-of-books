package pl.patryki.listofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryki.listofbooks.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findAllByOrderByNameAsc();

    List<Publisher> findAllByOrderByNameDesc();
}
