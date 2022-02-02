package models;

import models.enumoration.TypeUser;

public class Customer extends User{
    private String address;
    private long budget;

    public Customer(int id, String fullName, String nationalId, String password, TypeUser typeUser, String address, long budget) {
        super(id, fullName, nationalId, password, typeUser);
        this.address = address;
        this.budget = budget;
    }

    public Customer() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }
}
