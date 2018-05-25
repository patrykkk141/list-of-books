package pl.patryki.listofbooks;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.patryki.listofbooks.model.Publisher;
import pl.patryki.listofbooks.repository.PublisherRepository;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@DataJpaTest
public class PublisherRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    public void findPublisherByNameWithSortingTest() {
        Publisher publisher1 = new Publisher("Arka", "address2", "arka@example.com");
        Publisher publisher2 = new Publisher("Helion", "address3", "helion@example.com");
        Publisher publisher3 = new Publisher("NowaEra", "address1", "nowaera@example.com");

        List<Publisher> list = Arrays.asList(publisher1, publisher2, publisher3);
        List<Publisher> reverseList = Arrays.asList(publisher3, publisher2, publisher1);

        testEntityManager.persist(publisher1);
        testEntityManager.persist(publisher2);
        testEntityManager.persist(publisher3);

        List<Publisher> listSortedAsc = publisherRepository.findAllByOrderByNameAsc();
        List<Publisher> listSortedDesc = publisherRepository.findAllByOrderByNameDesc();

        Assert.assertEquals(list, listSortedAsc);
        Assert.assertEquals(reverseList, listSortedDesc);

    }
}
