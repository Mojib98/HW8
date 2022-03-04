package repository;

import models.Customer;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    static SessionFactory sessionFactory;
   static CustomerRepository customerRepository;

    @BeforeAll
   static void check(){
         sessionFactory = SessionFactorySingleton.getInstance();
         customerRepository = new CustomerRepository();
    }
    @Test
    void add() {
        Customer customer = new Customer(0,0,"mojib","12",12,"aa","bir");
        customerRepository.add(customer);
        Customer customer1;
        try (var session = sessionFactory.openSession()) {

                String hql = " from models.Customer " +
                        "where id =: id";
                var query=session.createQuery(hql,Customer.class);
                query.setParameter("id",customer.getId());
                customer1= query.getSingleResult();
            }
            assertEquals(customer.getId(),customer1.getId());
    }



    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void showinfo() {
    }

    @Test
    void howMuchHave() {
    }

    @Test
    void changeBudget() {
    }

    @Test
    void wid() {
    }
}