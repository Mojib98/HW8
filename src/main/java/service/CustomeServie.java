package service;

import models.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomeServie implements Service<Customer> {
private  Scanner scanner;
private  Random random;
private CustomerRepository customerRepository;

    public CustomeServie() throws SQLException, ClassNotFoundException {
        try {
             scanner = new Scanner(System.in);
             random = new Random();
             customerRepository = new CustomerRepository();
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

    @Override
    public int add() {
        try{
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
       return customerRepository.add(customer);
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<Customer> findAll()  {
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


