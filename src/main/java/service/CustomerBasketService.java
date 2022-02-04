package service;

import models.CustomerBasket;
import repository.CustomerBasketRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerBasketService implements Service<CustomerBasket> {
Scanner scanner;
ProductService productService;
CustomerBasket customerBasket;
CustomerBasketService customerBasketService;
CustomerBasketRepository customerBasketRepository;
private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerBasketService() throws SQLException, ClassNotFoundException {
        productService = new ProductService();
        scanner=new Scanner(System.in);
        customerBasketRepository = new CustomerBasketRepository();
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
            return customerBasketRepository.add(customerBasket);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public List<CustomerBasket> findAll() {
        return null;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
