package repository;

import models.CustomerBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBasketRepository implements Repository<CustomerBasket> {
    Connection connection;
    PreparedStatement preparedStatement;
    CustomerBasket customerBasket;

    public CustomerBasketRepository() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }

    @Override
    public int add(CustomerBasket customerBasket) {
        try {
            String sql = "INSERT INTO customerbasket(customerid, productid, numberproduct, price) VALUES (?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,customerBasket.getIdCustomer());
            preparedStatement.setInt(2,customerBasket.getIdProduct());
            preparedStatement.setInt(3,customerBasket.getNumber());
            preparedStatement.setFloat(4,customerBasket.Price());
            return preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("bad code");
        }
        return 0;
    }

    @Override
    public List<CustomerBasket> findAll() {
        List<CustomerBasket> list=new ArrayList<>();
        try {
            String sql ="SELECT * FROM customerbasket";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customerBasket = new CustomerBasket();
                customerBasket.setIdCustomer(resultSet.getInt(2));
                customerBasket.setIdProduct(resultSet.getInt(3));
                customerBasket.setNumber(resultSet.getInt(4));
                customerBasket.setPrice(resultSet.getFloat(5));
                list.add(customerBasket);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(CustomerBasket o) {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
