package com.example.bookstoremanagement.controller;

import com.example.bookstoremanagement.service.MyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBooksController {

    @Autowired
    private MyBooksService myBooksService;

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        myBooksService.deleteById(id);
        return "redirect:/my_books";
    }


}
