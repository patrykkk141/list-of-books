package pl.patryki.listofbooks.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookDto {

    private Long bookId;
    @NotBlank(message = "Title must not be blank")
    private String title;
    @NotBlank(message = "Author must not be blank")
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please pick date")
    private Date releaseDate;
    @Min(value = 1, message = "Select publisher form list")
    private long publisherId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }
}
