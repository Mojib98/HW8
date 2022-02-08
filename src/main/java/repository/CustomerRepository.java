package repository;

import models.Customer;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    PreparedStatement preparedStatement;
    Connection connection ;


    public CustomerRepository() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }

    @Override
    public int add(Customer custumer) throws SQLException {
        String sql="INSERT INTO userstore(IdUser,fullName,nationalId,password" +
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
            custumer = new Customer(id,name,nationalId,password,type,addres,budget);
            list.add(custumer);
        }
        return list;
        }


    @Override
    public int update(Customer custumer)  {
        return 0;
    }


    @Override
    public int delete(int id) throws SQLException {
        String sql="DELETE FROM userstore WHERE IdUser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
    public Customer showinfo(int id) throws SQLException {
        String sql = "SELECT * FROM userstore WHERE iduser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
            String name = resultSet.getString(3);
            String nationalId=resultSet.getString(4);
            int password = resultSet.getInt(5);
            String type=resultSet.getString(6);
            String addres=resultSet.getString(7);
            float budget=resultSet.getFloat(8);
           Customer custumer = new Customer(id,name,nationalId,password,type,addres,budget);
            return custumer;
    }
}
