package com.laljisingh.hibernateMapping.repository;


import com.laljisingh.hibernateMapping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByAuthor(String author);

    Book findByPrice(Integer price);
    List<Book> findByAuthorOrTitle(String author, String title);





}
