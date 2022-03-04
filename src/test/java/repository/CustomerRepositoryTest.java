package repository;

import models.Customer;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    static SessionFactory sessionFactory;
   static CustomerRepository customerRepository;
   Customer customer;

    @BeforeAll
   static void check(){
         sessionFactory = SessionFactorySingleton.getInstance();
         customerRepository = new CustomerRepository();
    }
    @BeforeEach
    void madeCustome(){
         customer = new Customer(0,0,"mojib","12",12,"aa","bir");
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(customer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }
    @AfterEach
    void clear(){
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.delete(customer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }


    }}
  /*  @AfterAll
   static void deleteAll(){
        try (var session = sessionFactory.openSession()) {
            String stringQuery = "DELETE FROM models.Customer";
        Query query = session.createQuery(stringQuery);
        query.executeUpdate();
    }
        }*/

    @Test
    void add() {
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
        Customer customer1;
        customer.setBudget(100);
        customerRepository.update(customer);
        try (var session = sessionFactory.openSession()) {

            String hql = " from models.Customer " +
                "where id =: id";
        var query=session.createQuery(hql,Customer.class);
        query.setParameter("id",customer.getId());
        customer1= query.getSingleResult();
    }
        System.out.println(customer.getBudget()+" "+customer1.getBudget());
        assertEquals(customer.getBudget(),customer1.getBudget());
    }

    @Test
    void delete() {
        int id = customer.getId();
        String s;
        Customer customer1;
        Customer customer2=new Customer(0,0,"mojib","12",12,"aa","bir");
        customerRepository.delete(customer2.getId());
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
               customer1= session.find(Customer.class,customer2.getId());
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
            customerRepository.add(customer2);
        assertEquals(null,customer1);


    }}

    @Test
    void showinfo() {
    }

    @Test
    void howMuchHave() {

        float howMuch=customerRepository.HowMuchHave(customer.getId());
        assertEquals(howMuch,customer.getBudget());

    }

    @Test
    void changeBudget() {

        System.out.println(customer.getId());
        customerRepository.changeBudget(customer.getId(),2000);
        float howMuch=customerRepository.HowMuchHave(customer.getId());
        assertEquals(2000,howMuch);



    }

    @Test
    void wid() {
        Customer customer = new Customer(0,200,"mojib","12",12,"aa","bir");
        customerRepository.add(customer);
        System.out.println(customer.getId());
        customerRepository.wid(customer.getId(),200);
        float howMuch=customerRepository.HowMuchHave(customer.getId());
        assertEquals(0,howMuch);

    }
}