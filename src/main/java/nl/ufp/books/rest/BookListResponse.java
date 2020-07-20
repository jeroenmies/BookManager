package nl.ufp.books.rest;

import nl.ufp.books.Book;

import java.util.List;

public class BookListResponse {
    private List<Book> books;

    public BookListResponse(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
