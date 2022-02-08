package repository;

import models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements Repository<Admin> {
    PreparedStatement preparedStatement;
    Connection connection;

    public AdminRepository() throws SQLException, ClassNotFoundException {

        connection = Singleton.getInstance().getConnection();

    }


    @Override
    public int add(Admin admin) throws SQLException {
        String sql = "INSERT INTO userstore(IdUser,fullName,nationalId,password" +
                ",kind) VALUES(?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, admin.getId());
        preparedStatement.setString(2, admin.getFullName());
        preparedStatement.setString(3, admin.getNationalId());
        preparedStatement.setInt(4, admin.getPassword());
        preparedStatement.setString(5, admin.getTypeUser());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        Admin admin;
        List<Admin> list = new ArrayList<Admin>();
        String sql = "SELECT * FROM userstore " +
                "WHERE kind = 'ADMIN'";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String nationalId = resultSet.getString(4);
            int password = resultSet.getInt(5);
            String type = resultSet.getString(6);
            admin = new Admin(id, name, nationalId, password, type);
            list.add(admin);
        }
        return list;
    }

    @Override
    public int update(Admin admin) throws SQLException {
        String sql = "UPDATE userstore set password=? where nationalid =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, admin.getPassword());
        preparedStatement.setString(2, admin.getNationalId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM userstore WHERE IdUser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public Admin seeMyInfo(int id) throws SQLException {
        Admin admin;
        String sql = "SELECT * FROM userstore WHERE iduser = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String name = resultSet.getString(3);
        String nationalId = resultSet.getString(4);
        int password = resultSet.getInt(5);
        String type = resultSet.getString(6);
        admin = new Admin(id, name, nationalId, password, type);
        return admin;
    }
}
