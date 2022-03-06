package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionFactorySingletonTest {
    static SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    static Session session;
    //     static Session session1;
    @BeforeAll
    static void creat(){
        sessionFactory = SessionFactorySingleton.getInstance();
        session = sessionFactory.openSession();
    }
    @Test
    @Order(1)
    void testConnection(){
        assertEquals(true,session.isOpen());
        session.isConnected();

//        assertEquals(true,session.isConnected());

    }
    @Order(2)
    @Test
    void testConnectionCon(){
        assertEquals(true,session.isConnected());
    }

}