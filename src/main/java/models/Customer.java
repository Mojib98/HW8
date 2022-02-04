package models;

public class Customer extends User {
    private String address;
    private float budget;

    public Customer(int id, String fullName, String nationalId, int password, String typeUser, String address, float budget) {
        super(id, fullName, nationalId, password, typeUser);
        this.address = address;
        this.budget = budget;
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
}
