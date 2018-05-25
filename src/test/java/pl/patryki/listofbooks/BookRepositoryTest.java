package pl.patryki.listofbooks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.patryki.listofbooks.model.Book;
import pl.patryki.listofbooks.repository.BookRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void saveBook() {

    }

    @Test
    public void findBooksByTileWithSortingTest() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse("01.01.2018");

        Book book1 = new Book("Bar", "author1", date);
        Book book2 = new Book("Foo", "author2", date);
        Book book3 = new Book("Zet", "author3", date);

        List<Book> givenList = Arrays.asList(book1, book2, book3);
        List<Book> reverseGivenList = Arrays.asList(book3, book2, book1);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);

        List<Book> ascList = bookRepository.findAllByOrderByTitleAsc();
        List<Book> descList = bookRepository.findAllByOrderByTitleDesc();

        Assert.assertEquals(givenList, ascList);
        Assert.assertEquals(reverseGivenList, descList);
    }

}
