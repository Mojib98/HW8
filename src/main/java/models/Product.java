package models;

public class Product {
    private int id,adminId,categoryId,brandId,number;
    private String name;
    private float price;
    private int serialId;

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public Product(int id, int adminId, int number, String name, float price) {
        this.id = id;
        this.adminId = adminId;
        //this.categoryId = categoryId;
      //  this.brandId = brandId;
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + serialId +
                ", adminId=" + adminId +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                " " +
                '}';
    }
}
