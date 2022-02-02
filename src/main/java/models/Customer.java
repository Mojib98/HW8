package models;

import models.enumoration.TypeUser;

public class Customer extends User{
    private String address;
    private double budget;

    public Customer(int id, String fullName, String nationalId, String password, TypeUser typeUser, String address, double budget) {
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
