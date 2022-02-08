package service;

import models.CustomerBasket;
import repository.CustomerBasketRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBasketService implements Service<CustomerBasket> {
    Scanner scanner;
    ProductService productService;
    CustomerBasket customerBasket;
    CustomerBasketService customerBasketService;
    CustomerBasketRepository customerBasketRepository;
    private int customerId;
    private float totalPrice;

    public float getTotalPrice() {
        return totalPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerBasketService() throws SQLException, ClassNotFoundException {
        productService = new ProductService();
        scanner = new Scanner(System.in);
        customerBasketRepository = new CustomerBasketRepository();
        totalPrice = 0;
    }

    @Override
    public int add() {
        try {
            System.out.println("please insert id ");
            int id = scanner.nextInt();
            System.out.println("please insert number");
            int number = scanner.nextInt();
            customerBasket = productService.giveproduce(id, number);
            customerBasket.setNumber(number);
            customerBasket.setIdCustomer(this.customerId);
            totalPrice += customerBasket.Price() * number;
            return customerBasketRepository.add(customerBasket);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CustomerBasket> findAll() {
        List<CustomerBasket> cust = new ArrayList<>();
        List<CustomerBasket> cust2 = new ArrayList<>();
        cust = customerBasketRepository.findAll();
        for (CustomerBasket s : cust
        ) {
            if (s.getIdCustomer() == customerId) {
                cust2.add(s);
            }

        }
        return cust2;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        try {
            System.out.println("please insert id");
            int ids = scanner.nextInt();
            System.out.println("please insert number");
            int num = scanner.nextInt();
            productService.returnPeoduce(ids, num);
            return customerBasketRepository.delete(ids);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void show() {
        List<CustomerBasket> c = new ArrayList<>();
        c = findAll();
        for (CustomerBasket s : c
        ) {
            if (s.getIdCustomer() == customerId) {
                System.out.println(s);
            }

        }


    }

    public void deleteFromBasket(){
        try {
            customerBasketRepository.deleteBasket(customerId);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

