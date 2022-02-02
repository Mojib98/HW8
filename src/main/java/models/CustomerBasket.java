package models;

public class CustomerBasket {
    private int idCustomer,idProduct,number;
    private double totalPrice;

    public CustomerBasket(int idCustomer, int idProduct, int number, double totalPrice) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.number = number;
        this.totalPrice = totalPrice;
    }

    public CustomerBasket() {
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
