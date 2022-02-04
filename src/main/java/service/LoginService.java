package service;

import repository.LoginUser;

import java.sql.SQLException;

public class LoginService {
    LoginUser loginUser = new LoginUser();

    public LoginService() throws SQLException, ClassNotFoundException {
    }

    public boolean isHere(int id,int passwore) throws SQLException {
        return loginUser.isHere(id,passwore);
    }

}
