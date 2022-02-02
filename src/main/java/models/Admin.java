package models;

import models.enumoration.TypeUser;

public class Admin extends  User {
    public Admin(int id, String fullName, String nationalId, String password, TypeUser typeUser) {
        super(id, fullName, nationalId, password, typeUser);
    }
}
