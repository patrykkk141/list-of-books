package pl.patryki.listofbooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.patryki.listofbooks.model.Book;
import pl.patryki.listofbooks.repository.BookRepository;
import pl.patryki.listofbooks.service.BookService;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {


    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepositoryMock;

    @Before
    public void setUp() {
        Optional<Book> sampleBook = Optional.of(new Book("some title", "some author", null));
        Mockito.when(bookRepositoryMock.findById(0l)).thenReturn(sampleBook);
    }

    @Test
    public void findByIdTest() {
        Optional<Book> book = bookService.findById(0l);

        Assert.assertEquals(book, bookService.findById(0l));
    }

    @Before
    public void setUpExistsById() {
        Mockito.when(bookRepositoryMock.existsById(0l)).thenReturn(false);
    }

    @Test
    public void existsByIdTest() {
        Assert.assertFalse(bookService.existsById(0));
    }
}
