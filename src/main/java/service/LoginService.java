package service;

import repository.LoginUser;

import java.sql.SQLException;

public class LoginService {
    LoginUser loginUser;

    public LoginService() throws SQLException, ClassNotFoundException {

        try {
            loginUser = new LoginUser();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public boolean isHere(int id,int password) throws SQLException {

        try {
            return loginUser.isHere(id,password);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("user not find");
            return false;
        }
    }

}
