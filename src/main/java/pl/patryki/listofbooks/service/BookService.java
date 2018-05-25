package pl.patryki.listofbooks.service;

import org.springframework.stereotype.Service;
import pl.patryki.listofbooks.model.Book;
import pl.patryki.listofbooks.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public boolean existsById(long id) {
        return bookRepository.existsById(id);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllOrderByTitle() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public List<Book> findAllByOrderByTitleDesc() {
        return bookRepository.findAllByOrderByTitleDesc();
    }
}
