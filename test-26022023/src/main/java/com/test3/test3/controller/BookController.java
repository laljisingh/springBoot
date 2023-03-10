package com.test3.test3.controller;

import com.test3.test3.model.Book;
import com.test3.test3.model.Student;
import com.test3.test3.repository.StudentRepository;
import com.test3.test3.service.BookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/add-book")
    public String addBook(@RequestBody String newBook){
        JSONObject json = new JSONObject(newBook);
        Book book = setBook(json);
        bookService.addBook(book);
        return book.toString();
    }
    @GetMapping("/get-books")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @DeleteMapping("/delete-book/{book_id}")
    public String deleteBook(@PathVariable String book_id){
        return bookService.deleteBook(book_id);
    }
    @PutMapping("/update-book/{bookid}")
    public String updateBook(@RequestBody String updatedBook,@PathVariable String bookid){
        JSONObject json = new JSONObject(updatedBook);
        Book book = setBook(json);
       return bookService.updateBook(book, bookid);
    }


    private Book setBook(JSONObject json) {
        Book book = new Book();
        book.setTitle(json.getString("title"));
        book.setPrice(json.getString("price"));
        book.setAuthor(json.getString("author"));
        book.setDescription(json.getString("description"));

        String studentid = json.getString("student_id");
        Student student = studentRepository.findById(Integer.valueOf(studentid)).get();
        book.setStudent(student);
        return book;
    }


}
