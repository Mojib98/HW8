package models;

public abstract class Custumer {
    private int id;
    private String fullName,nationalId,address;
    int password;
    float budget;
    String typeUser;

    public Custumer(int id, String fullName, String nationalId, int password, String typeUser) {
    }

    public Custumer(int id, String fullName, String nationalId, String address, int password, float budget, String typeUser) {
        this.id = id;
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.address = address;
        this.password = password;
        this.budget = budget;
        this.typeUser = typeUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
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
