package repository;
import models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements Repository<Admin>{
    PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();

    public AdminRepository() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add(Admin admin) throws SQLException {
        String sql="INSERT INTO userstore(fullName,nationalId,password" +
                ",kind) VALUES(?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin.getFullName());
        preparedStatement.setString(2,admin.getNationalId());
        preparedStatement.setInt(3,admin.getPassword());
        preparedStatement.setString(4,admin.getTypeUser());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        Admin admin;
        List<Admin> list=new ArrayList<Admin>();
        String sql = "SELECT * FROM userstore";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id =resultSet.getInt(1);
            String name = resultSet.getString(2);
            String nationalId=resultSet.getString(3);
            int password = resultSet.getInt(4);
            String type=resultSet.getString(5);
            admin = new Admin(id,name,nationalId,password,type);
            list.add(admin);
        }
        return list;
    }

    @Override
    public int update(Admin admin) throws SQLException {
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
