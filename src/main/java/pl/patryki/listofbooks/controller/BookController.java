package pl.patryki.listofbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.patryki.listofbooks.dto.BookDto;
import pl.patryki.listofbooks.exceptions.NotFoundException;
import pl.patryki.listofbooks.model.Book;
import pl.patryki.listofbooks.model.Publisher;
import pl.patryki.listofbooks.service.BookService;
import pl.patryki.listofbooks.service.PublisherService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping(value = {"/books", "/"})
    public String showBooksPage(Model model, @RequestParam(value = "srt", required = false) String srt) {
        if (srt == null) {
            model.addAttribute("listOfBooks", bookService.findAll());
        } else if (srt.equals("asc")) {
            model.addAttribute("listOfBooks", bookService.findAllOrderByTitle());
        } else {
            model.addAttribute("listOfBooks", bookService.findAllByOrderByTitleDesc());
        }

        return "books";
    }

    @GetMapping("/insert/book")
    public String showInsertBookPage(Model model, BookDto bookDto) {
        model.addAttribute("publishers", publisherService.findAll());
        return "insert-book";
    }

    @PostMapping("/insert/book")
    public String insertBook(@ModelAttribute @Valid BookDto bookDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherService.findAll());
            return "insert-book";
        } else {
            Book newBook = new Book();
            Optional<Publisher> publisher = publisherService.findById(bookDto.getPublisherId());

            newBook.setTitle(bookDto.getTitle());
            newBook.setAuthor(bookDto.getAuthor());
            newBook.setReleaseDate(bookDto.getReleaseDate());
            if (publisher.isPresent()) {
                newBook.setPublisher(publisher.get());
            }
            if (bookDto.getBookId() != null) {
                newBook.setBookId(bookDto.getBookId());
            }
            bookService.saveBook(newBook);
            return "redirect:/books";
        }
    }

    @GetMapping("/book/edit")
    public String editBook(@RequestParam("id") long id, BookDto bookDto, Model model) throws NotFoundException {
        Optional<Book> book = bookService.findById(id);

        if (!book.isPresent()) {
            throw new NotFoundException("Book not found");
        } else {

            bookDto.setBookId(book.get().getBookId());
            bookDto.setTitle(book.get().getTitle());
            bookDto.setAuthor(book.get().getAuthor());
            bookDto.setReleaseDate(book.get().getReleaseDate());
            bookDto.setPublisherId(book.get().getPublisher().getPublisherId());
        }

        model.addAttribute("publishers", publisherService.findAll());
        return "insert-book";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam("id") long id) throws NotFoundException {
        if (bookService.existsById(id)) {
            bookService.deleteById(id);
        } else {
            throw new NotFoundException("Book not found");
        }
        return "redirect:/books";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
