package com.laljisingh.hibernateMapping.controller;

import com.laljisingh.hibernateMapping.model.Book;
import com.laljisingh.hibernateMapping.model.Hostel;
import com.laljisingh.hibernateMapping.model.Student;
import com.laljisingh.hibernateMapping.repository.StudentRepository;
import com.laljisingh.hibernateMapping.service.BookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/add-book")
    public Book addBook(@RequestBody String newBook){
        JSONObject json = new JSONObject(newBook);
        Book book = setBook(json);
        Book bk = bookService.addBook(book);
        return bk;
    }
    @GetMapping("/get-book")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    private Book setBook(JSONObject json) {
        Book book = new Book();
        book.setTitle(json.getString("title"));
        book.setPrice(json.getString("price"));
        book.setAuthor(json.getString("author"));
        book.setDescription(json.getString("description"));
        Student student=null;
        for (Student student1 : studentRepository.findAll()) {
            if(student1.getStudent_Id()==(Integer.valueOf(json.getString("student_id")))){
                student = studentRepository.findById(Integer.valueOf(json.getString("student_id"))).get();
                break;
            }
        }
        book.setStudent(student);
        return book;
    }


}
