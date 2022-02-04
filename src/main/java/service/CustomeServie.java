package service;

import models.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomeServie implements Service<Customer> {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    CustomerRepository customerRepository = new CustomerRepository();

    public CustomeServie() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add() throws SQLException {
        Customer customer;
        System.out.println("please insert your name");
        String name=scanner.next();
        System.out.println("plese insert nationalId");
        String national = scanner.next();
        System.out.println("plese set password");
        int password = scanner.nextInt();
        System.out.println("please insert your address");
        String address = scanner.next();
        int id = random.ints(4, 100, 200).findFirst().getAsInt();
        customer = new Customer(id,name,national,password,"CUSTUMER",address,10000);
        customerRepository.add(customer);
        return 0;

    }

    @Override
    public List<Customer> findAll() throws SQLException {
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
    public  void showMyInfo(){

    }
}
