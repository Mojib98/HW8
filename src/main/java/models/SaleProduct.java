package models;

import java.sql.Date;

public class SaleProduct {
    private int idCustomer,idProduct,number;
    private double price;
    Date date;

    public SaleProduct(int idCustomer, int idProduct, int number, double price, Date date) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.number = number;
        this.price = price;
        this.date = date;
    }

    public SaleProduct() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
