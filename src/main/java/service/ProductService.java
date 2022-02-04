package service;

import models.Product;
import repository.ProdoctRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements Service<Product> {
    Scanner scanner;
    Product product;
    private int adminId;
    ProdoctRepository prodoctRepository;

    public ProductService() {
        try {
            prodoctRepository = new ProdoctRepository();
            scanner = new Scanner(System.in);
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public int add() {
        try{
        System.out.println("insert id");
        int id = scanner.nextInt();
        System.out.println("please insert name");
        String name = scanner.next();
       // int admin = scanner.nextInt();
        System.out.println("insert number");
        int num = scanner.nextInt();
        System.out.println("insert price");
        float price = scanner.nextFloat();
        product=new Product(id,this.adminId,num,name,price);
      return   prodoctRepository.add(product);
    }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;}


    @Override
    public List<Product> findAll()  {
        try {

        List<Product> list=new ArrayList<Product>();
        list = prodoctRepository.findAll();
        for (Product p:list
             ) {
            System.out.println(p);
        }

    }catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception r){
            r.printStackTrace();

        }
        return null;
    }

    @Override
    public int update()  {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
