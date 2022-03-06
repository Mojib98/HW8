package repository;

import models.Customer;
import models.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    PreparedStatement preparedStatement;
    Connection connection ;
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();



    @Override
    public int add(Customer custumer)  {
        /*String sql="INSERT INTO userstore(IdUser,fullName,nationalId,password" +
                ",kind,address,budget) VALUES(?,?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,custumer.getId());
        preparedStatement.setString(2,custumer.getFullName());
        preparedStatement.setString(3,custumer.getNationalId());
        preparedStatement.setInt(4,custumer.getPassword());
        preparedStatement.setString(5,"CUSTOMER");
        preparedStatement.setString(6,custumer.getAddress());
        preparedStatement.setFloat(7,custumer.getBudget());
        return preparedStatement.executeUpdate();
        */
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(custumer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
            return 0;
        }


    @Override
    public List<Customer> findAll() throws SQLException {
        Customer custumer;
        List<Customer> list=new ArrayList<Customer>();
        String sql = "SELECT * FROM userstore";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id =resultSet.getInt(2);
            String name = resultSet.getString(3);
            String nationalId=resultSet.getString(4);
            int password = resultSet.getInt(5);
            String type=resultSet.getString(6);
            String addres=resultSet.getString(7);
            float budget=resultSet.getFloat(8);
            custumer = new Customer(id,name,nationalId,password,type,budget,addres);
            list.add(custumer);
        }
        return list;
        }


    @Override
    public int update(Customer custumer)  {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.update(custumer);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
        return 0;
    }


    @Override
    public int delete(int id)  {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                String hql = "delete from models.Customer " +
                        "where id =:id";
                var query=session.createQuery(hql);
                query.setParameter("id",id);
                return query.executeUpdate();
            } catch (Exception e) {
                throw e;
            }

    }

    }
    public Customer showinfo(int id)  {
            try (var session = sessionFactory.openSession()) {
                try {
                    String hql = " from models.Customer " +
                            "where id =:id";
                    var query=session.createQuery(hql,Customer.class);
                    query.setParameter("id",id);
                   var c= query.getSingleResult();
                   return c;
                } catch (Exception e) {
                    throw e;
                }
        }

        }
    public float  HowMuchHave(int id)  {
            try (var session = sessionFactory.openSession()) {
                try {
                    String hql = "select c.budget from models.Customer c " +
                            "where c.id =:id";
                    var query=session.createQuery(hql,Float.class);
                    query.setParameter("id",id);
                    var c= query.getSingleResult();
                    return c;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return  0;


        }
    public void changeBudget(int id,float budget) {
        float t = HowMuchHave(id)+(budget);
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            try {
                String hql = "update  models.Customer c set c.budget =: b  " +
                        "where c.id =:id";
                var query=session.createQuery(hql);
                query.setParameter("id",id);
                query.setParameter("b",t);
                query.executeUpdate();
                transaction.commit();

            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }

    }
    public void wid(int id,float budget)  {
       // float t = HowMuchHave(id)-(budget);
        changeBudget(id,-budget);

    }
}
