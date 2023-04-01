package com.example.bookstoremanagement.service;

import com.example.bookstoremanagement.model.Book;
import com.example.bookstoremanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }


}
