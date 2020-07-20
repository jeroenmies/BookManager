package nl.ufp.books.rest;

import nl.ufp.books.Book;
import nl.ufp.books.repository.BooksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class BooksController {

    private BooksRepository booksRepository;

    public BooksController(BooksRepository repository) {
        this.booksRepository = repository;
    }

    @GetMapping("/books")
    public ResponseEntity<BookListResponse> getListOfBooks() {
        Iterable<Book> books = this.booksRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        books.forEach(book -> bookList.add(book));
        return ResponseEntity.ok(new BookListResponse(bookList));
    }
}
