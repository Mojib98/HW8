package models;

import models.enumoration.TypeUser;

public class Admin extends User {
    public Admin(int id, String fullName, String nationalId, int password, String typeUser) {
        super(id, fullName, nationalId, password, typeUser);
    }

}
