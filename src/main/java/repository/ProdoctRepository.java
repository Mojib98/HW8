package repository;

import models.CustomerBasket;
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

    public ProdoctRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add(Product product)  {
       String sql = "INSERT INTO product(adminId,categoryId,nameProduct" +
               ",numberProduct,price) VALUES(?,?,?,?,?)";
       try {

       preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setInt(1,product.getAdminId());
       preparedStatement.setInt(2,product.getId());
       preparedStatement.setString(3,product.getName());
       preparedStatement.setInt(4,product.getNumber());
       preparedStatement.setFloat(4,product.getPrice());
       return preparedStatement.executeUpdate();

    }catch (SQLException e){
           e.printStackTrace();
       }return 0;}

    @Override
    public List<Product> findAll()  {
        String sql = "SELECT * FROM product";
        try{
        List<Product> list = new ArrayList<Product>();
        Product product;
        preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            product = new Product();
            product.setSerialId(resultSet.getInt(1));
            product.setAdminId(resultSet.getInt(2));
            product.setCategoryId(resultSet.getInt(3));
            product.setName(resultSet.getString(4));
            product.setNumber(resultSet.getInt(5));
            product.setPrice(resultSet.getFloat(6));
            list.add(product);

        }
        return list;
    }catch (SQLException e){
            e.printStackTrace();
        }return null;}

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
    public CustomerBasket give(int id,int num) throws SQLException {
        CustomerBasket customerBasket = new CustomerBasket();
        String sql ="SELECT * FROM product WHERE id=?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        customerBasket.setIdProduct(resultSet.getInt(5));
        customerBasket.setName(resultSet.getString(4));
        return customerBasket;
    }
}
