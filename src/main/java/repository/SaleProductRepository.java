package repository;

import models.CustomerBasket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaleProductRepository {
    Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;

    public SaleProductRepository() throws SQLException, ClassNotFoundException {
    }

    public void add(List<CustomerBasket> list) throws SQLException {
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        String sql="INSERT INTO saleproduct(customerid, productid, numberproduct, price, datesell) VALUES " +
                "(?,?,?,?,?)" ;
        preparedStatement = connection.prepareStatement(sql);
        for (CustomerBasket c:list
             ) {
            preparedStatement.setInt(1,c.getIdCustomer());
            preparedStatement.setInt(2,c.getIdProduct());
            preparedStatement.setInt(3,c.getNumber());
            preparedStatement.setFloat(4,c.Price());
            preparedStatement.setDate(5,date);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }
}
