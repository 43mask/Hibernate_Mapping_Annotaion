package org.mask.dao;

import org.mask.entity.Book;

import java.util.List;

public interface BookDao {

    //add book
    void add(Book book);

    //read all
    List<Book> getAll();

    //read by id
    Book getById(Long id);

    //update
    void update(Book book);

    //delete
    void remove(Book book);

}
