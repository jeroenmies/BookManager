package nl.ufp.books.repository;

import nl.ufp.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {

}
