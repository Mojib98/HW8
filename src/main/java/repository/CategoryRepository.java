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
    Connection connection = Singleton.getInstance().getConnection();

    public CategoryRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add(Category category) throws SQLException {
        String sql = "INSERT INTO category(parentId,nameCategory) VALUES(?.?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,category.getParentId());
        preparedStatement.setString(2,category.getName());
        return preparedStatement.executeUpdate();

    }

    @Override
    public List<Category> findAll() throws SQLException {
        Category category;
        List<Category> list=new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id =resultSet.getInt(2);
            String name = resultSet.getString(3);
            category = new Category(id,name);
            list.add(category);
        }
        return list;    }

    @Override
    public int update(Category category) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
