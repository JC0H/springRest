package com.jcoh.springRest.book;

import com.jcoh.springRest.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public HelloWorld helloWorld(){
        return new HelloWorld("Hello World");
    }

    @GetMapping("/hello/variable/{name}")
    public HelloWorld helloWorldVariable(@PathVariable String name){
        return new HelloWorld(String.format("Hello World, %s", name));
    }

    @GetMapping("/show-books")
    public List<Book> getBooks(){
        return bookService.getBooks() ;
    }

    @PostMapping("/save-book")
    public void saveBook(@RequestBody Book book){
        Book b = bookService.save(book) ;
    }

    @GetMapping("/get-book-by-Id/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBooksById(id) ;
    }
}
