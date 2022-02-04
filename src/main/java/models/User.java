package models;

public abstract class User {
    private int id;
    private String fullName,nationalId;
    int password;
    String typeUser;



    public User(int id, String fullName, String nationalId,int password, String typeUser) {
        this.id = id;
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.password = password;
        this.typeUser = typeUser;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
