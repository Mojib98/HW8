package service;

import models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements Service<Product> {
    Scanner scanner = new Scanner(System.in);
    Product product;
    private int adminId;

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public int add() throws SQLException {
        System.out.println("insert id");
        int id = scanner.nextInt();
        System.out.println("please insert name");
        String name = scanner.next();
       // int admin = scanner.nextInt();
        System.out.println("insert number");
        int num = scanner.nextInt();
        System.out.println("insert price");
        float price = scanner.nextFloat();
        product=new Product(id,adminId,num,name,price);
        return 0;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> list=new ArrayList<Product>();
        for (Product p:list
             ) {
            p.toString();
        }
        return null;
    }

    @Override
    public int update() throws SQLException {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
