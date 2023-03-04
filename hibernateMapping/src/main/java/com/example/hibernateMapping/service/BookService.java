package com.example.hibernateMapping.service;

import com.example.hibernateMapping.model.Book;
import com.example.hibernateMapping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
