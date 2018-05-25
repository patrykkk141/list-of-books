package pl.patryki.listofbooks.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publisherId;
    @Column(nullable = false)
    private String name;
    private String address;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> listOfBooks;

    public Publisher() {
    }

    public Publisher(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
