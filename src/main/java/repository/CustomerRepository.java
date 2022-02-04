package repository;

import models.Admin;
import models.Customer;
import models.Custumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Custumer> {
    PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();


    public CustomerRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add(Custumer custumer) throws SQLException {
        String sql="INSERT INTO userstore(fullName,nationalId,password" +
                ",kind,address,budget) VALUES(?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,custumer.getFullName());
        preparedStatement.setString(2,custumer.getNationalId());
        preparedStatement.setInt(3,custumer.getPassword());
        preparedStatement.setString(4,custumer.getTypeUser());
        preparedStatement.setString(4,custumer.getAddress());
        preparedStatement.setFloat(5,custumer.getBudget());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Custumer> findAll() throws SQLException {
        Custumer custumer;
        List<Custumer> list=new ArrayList<Custumer>();
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
    public int update(Custumer custumer) throws SQLException {
        return 0;
    }


    @Override
    public int delete(int id) throws SQLException {
        String sql="DELETE FROM userstore WHERE IdUser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
}
