package repository;

import models.Admin;
import models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository<Category> {
    PreparedStatement preparedStatement;
    Connection connection;

    public CategoryRepository() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }

    @Override
    public int add(Category category) {
        try {

            String sql = "INSERT INTO category(barndid, name) VALUES(?.?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category.getParentId());
            preparedStatement.setString(2, category.getName());
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Category> findAll() throws SQLException {
        Category category;
        List<Category> list=new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(2);
            String name = resultSet.getString(3);
            category = new Category(id, name);
            list.add(category);
        }
        return list;    }

    @Override
    public int update(Category category)  {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql="DELETE FROM category WHERE barndid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();

    }
}
