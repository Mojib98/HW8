package models;

public class CustomerBasket {
    private int idCustomer,idProduct,number;
    private float Price;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CustomerBasket(int idCustomer, int idProduct, int number, float Price) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.number = number;
        this.Price = Price;
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

    public float Price() {
        return Price;
    }

    public void setPrice(float totalPrice) {
        this.Price = totalPrice;
    }

    @Override
    public String toString() {
        return "CustomerBasket{" +
                "idCustomer=" + idCustomer +
                ", idProduct=" + idProduct +
                ", number=" + number +
                ", Price=" + Price +
                ", name='" + name + '\'' +
                '}';
    }
}
