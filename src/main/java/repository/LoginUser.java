package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {
PreparedStatement preparedStatement;
    Connection connection = Singleton.getInstance().getConnection();

    public LoginUser() throws SQLException, ClassNotFoundException {
    }

    public boolean isHere(int id,int password) throws SQLException {
        String sql="SELECT  COUNT(*) FROM userstore WHERE " +
                "iduser=? AND password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getInt(1));
        if(resultSet.getInt(1)==1)
            return true;
        else
            return false;
    }
}
