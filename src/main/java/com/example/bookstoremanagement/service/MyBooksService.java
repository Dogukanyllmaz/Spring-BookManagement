package com.example.bookstoremanagement.service;

import com.example.bookstoremanagement.model.MyBooks;
import com.example.bookstoremanagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBook(MyBooks myBooks){
        myBookRepository.save(myBooks);
    }

    public List<MyBooks> getAllMyBook(){
        return myBookRepository.findAll();
    }

    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }


}
