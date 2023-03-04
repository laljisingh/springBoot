package com.laljisingh.hibernateMapping.service;


import com.laljisingh.hibernateMapping.model.Book;
import com.laljisingh.hibernateMapping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book addBook(Book book) {
       return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        bookRepository.findByPrice(546);
        return bookRepository.findAll();

    }
}
