package repository;

import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProdoctRepository implements Repository<Product>
{
    Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;

    @Override
    public int add(Product product) throws SQLException {
       String sql = "INSERT INTO produc(adminId,categoryId,nameProduct" +
               ",numberProduct,price) VALUES(?,?,?,?,?)";
       preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setInt(1,product.getAdminId());
       preparedStatement.setInt(2,product.getId());
       preparedStatement.setString(3,product.getName());
       preparedStatement.setInt(4,product.getNumber());
       preparedStatement.setFloat(4,product.getPrice());
       preparedStatement.executeUpdate();
        return 0;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        String sql = "SELECT * FROM product";
        List<Product> list = new ArrayList<Product>();
        Product product;
        preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            product = new Product();
            product.setAdminId(resultSet.getInt(1));
            product.setCategoryId(resultSet.getInt(2));
            product.setName(resultSet.getString(3));
            product.setNumber(resultSet.getInt(4));
            product.setPrice(resultSet.getFloat(5));
            list.add(product);

        }
        return list;
    }

    @Override
    public int update(Product product) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
