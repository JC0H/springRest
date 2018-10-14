package com.jcoh.springRest.book;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookService {
    private static List<Book> library = new ArrayList<>();

    private static int bookCount = 3;

    static {
        library.add(new Book(1,"Idiot","Dostoyevskiy"));
        library.add(new Book(2,"Karamazov brathers","Dostoyevskiy"));
        library.add(new Book(3,"Gamer","Dostoyevskiy"));
    }

    public List<Book> getBooks() {
        return library;
    }

    public Book save(Book book) {
        /*if (book.getId() == null){
            book.setId(++bookCount);
        }*/
        library.add(book);
        return book;
    }

    public Book getBooksById(int id) {
        for (Book b : library) {
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

}
