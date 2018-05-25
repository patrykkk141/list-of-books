package pl.patryki.listofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryki.listofbooks.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByTitleAsc();

    List<Book> findAllByOrderByTitleDesc();

}
