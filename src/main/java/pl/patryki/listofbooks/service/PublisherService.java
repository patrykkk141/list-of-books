package pl.patryki.listofbooks.service;

import org.springframework.stereotype.Service;
import pl.patryki.listofbooks.model.Publisher;
import pl.patryki.listofbooks.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findById(long id) {
        return publisherRepository.findById(id);
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deleteById(long id) {
        publisherRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return publisherRepository.existsById(id);
    }

    public List<Publisher> findAllByOrderByName() {
        return publisherRepository.findAllByOrderByNameAsc();
    }

    public List<Publisher> findAllByOrderByNameDesc() {
        return publisherRepository.findAllByOrderByNameDesc();
    }

}
