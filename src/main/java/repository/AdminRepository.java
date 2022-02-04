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
    Connection connection;

    public AdminRepository() throws SQLException, ClassNotFoundException {
        try {
            connection = Singleton.getInstance().getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    @Override
    public int add(Admin admin)  {
        try{
        String sql="INSERT INTO userstore(IdUser,fullName,nationalId,password" +
                ",kind) VALUES(?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,admin.getId());
        preparedStatement.setString(2,admin.getFullName());
        preparedStatement.setString(3,admin.getNationalId());
        preparedStatement.setInt(4,admin.getPassword());
        preparedStatement.setString(5,admin.getTypeUser());
        return preparedStatement.executeUpdate();
    }catch (SQLException e){
            System.out.println("sql wrong in adding");
            return 0;
        }
      catch (Exception e){
            e.printStackTrace();
            return 0;
      }}

    @Override
    public List<Admin> findAll() {
        Admin admin;
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Admin admin)  {
        try {
        String sql= "UPDATE userstore set psasword=? where nationaId =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,admin.getPassword());
        preparedStatement.setString(2, admin.getNationalId());
        return preparedStatement.executeUpdate();
    }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql="DELETE FROM userstore WHERE IdUser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
    public void addBudget(int id , float buget) throws SQLException {
        String sql = "UPDATE usertable set budget = ? where IdUser=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setFloat(1,buget);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
    }
}
