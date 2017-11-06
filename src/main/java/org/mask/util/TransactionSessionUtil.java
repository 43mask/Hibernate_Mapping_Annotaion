package org.mask.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionSessionUtil {

    //Session object
    private Session session;

    //Transaction object
    private Transaction transaction;

    //Get session method
    public Session getSession() {
        return session;
    }

    //Open transaction and session method
    public Session openTransactionSession() {
        session = SessionFactoryUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    //Close transaction and session
    public void closeTransactionSession() {
        transaction.commit();
        session.close();
    }
}
