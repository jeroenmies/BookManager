package nl.ufp.books.repository;

import nl.ufp.books.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;

    @Test
    public void CanCreateAndFindBooks() throws Exception {
        Book book1 = new Book("Ivanhoe");
        Book book2 = new Book("Robin Hood");
        booksRepository.save(book1);
        booksRepository.save(book2);

        List<Book> books = booksRepository.findAll();

        assertThat(books.get(0).getTitle()).isEqualTo(book1.getTitle());
        assertThat(books.get(1).getTitle()).isEqualTo(book2.getTitle());
        assertThat(books.size()).isEqualTo(2);
    }
}
