package com.example.bookstoremanagement.controller;

import com.example.bookstoremanagement.model.Book;
import com.example.bookstoremanagement.model.MyBooks;
import com.example.bookstoremanagement.service.BookService;
import com.example.bookstoremanagement.service.MyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBooksService myBooksService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/authors")
    public String bookAuthors(){
        return "authors";
    }

    @GetMapping("/publishers")
    public String bookPublishers(){
        return "publishers";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public ModelAndView getAllBook(){
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("books","book",list);
    }

    @RequestMapping("/my_books/{id}")
    public String addMyBooks(@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBooks myBooks = new MyBooks(b.getId(),b.getBookName(),b.getBookAuthor(),b.getBookPage(),b.getBookPublisher());
        myBooksService.saveMyBook(myBooks);
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @RequestMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBooks> list = myBooksService.getAllMyBook();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id , Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

}
