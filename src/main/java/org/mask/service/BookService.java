package org.mask.service;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mask.dao.BookDao;
import org.mask.entity.Book;
import org.mask.util.TransactionSessionUtil;

import java.util.List;

public class BookService extends TransactionSessionUtil implements BookDao {


    //Adding an object to the database
    public void add(Book book) {

        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(book);

        //close session with a transaction
        closeTransactionSession();

    }

    //Get the entire contents of the database
    public List<Book> getAll() {

        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM book";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Book.class);

        List<Book> addressList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return addressList;

    }

    //Get the contents of the database by id
    public Book getById(Long id){

        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM book WHERE ID = :id";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Book.class);
        query.setParameter("id", id);

        Book book = (Book) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return book;

    }

    //Edit database contents
    public void update(Book book) {

        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(book);

        //close session with a transaction
        closeTransactionSession();

    }

    //Remove database contents
    public void remove(Book book) {

        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(book);

        //close session with a transaction
        closeTransactionSession();

    }
}
