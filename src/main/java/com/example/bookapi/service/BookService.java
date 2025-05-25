package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final Map<Long, Book> bookStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    public Book getBookById(Long id) {
        return bookStore.get(id);
    }

    public Book addBook(Book book) {
        long id = idCounter.incrementAndGet();
        book.setId(id);
        bookStore.put(id, book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (!bookStore.containsKey(id)) {
            return null;
        }
        book.setId(id);
        bookStore.put(id, book);
        return book;
    }

    public boolean deleteBook(Long id) {
        return bookStore.remove(id) != null;
    }
}
