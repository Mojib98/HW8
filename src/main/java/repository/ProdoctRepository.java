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
       String sql = "INSERT INTO product(adminId,idproduct,categoryId,nameProduct" +
               ",numberProduct,price) VALUES(?,?,?,?,?,?)";
       try {

       preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setInt(1,product.getAdminId());
       preparedStatement.setInt(2,product.getId());
       preparedStatement.setInt(3,product.getCategoryId());
       preparedStatement.setString(4,product.getName());
       preparedStatement.setInt(5,product.getNumber());
       preparedStatement.setFloat(6,product.getPrice());
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
    public int update(Product product) throws SQLException {
        String sql = "UPDATE product SET numberproduct=? WHERE id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(2,product.getId());
        preparedStatement.setInt(1,product.getNumber());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql ="delete from product where id=?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
    public CustomerBasket give(int id,int num) throws SQLException {
        CustomerBasket customerBasket = new CustomerBasket();
        String sql ="SELECT * FROM product WHERE id = ?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
       // customerBasket.setName(resultSet.getString(3));
        customerBasket.setIdProduct(id);
        customerBasket.setName(resultSet.getString(4));
      //  customerBasket.setNumber(num);
        //resultSet.next();
     //   System.out.println(resultSet.next());
        System.out.println(resultSet.getFloat("price"));
        customerBasket.setPrice(resultSet.getFloat(6));}
        updateNumber(id,-num);
        return customerBasket;
    }
    private void updateNumber(int id , int num) throws SQLException {
        String sql ="SELECT numberproduct  FROM product WHERE id=?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet r = preparedStatement.executeQuery();
        r.next();
        System.out.println(r.getInt(1));
        int nu = r.getInt(1) + num;
        Product p = new Product();
        p.setNumber(nu);
        p.setId(id);
       update(p);

    }
    public void returnPeoduce(int id,int num) throws SQLException {
        updateNumber(id,num);
    }

    public List<Product> productscategory(int id) throws SQLException {
        String sql = "SELECT * FROM product where categoryid=?";
        preparedStatement.setInt(1,id);
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
    }
}
