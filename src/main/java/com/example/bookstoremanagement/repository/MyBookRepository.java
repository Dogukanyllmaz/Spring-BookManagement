package com.example.bookstoremanagement.repository;

import com.example.bookstoremanagement.model.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooks, Integer> {


}
