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
private int id;

    public void setId(int id) {
        this.id = id;
    }

    public CustomeServie() throws SQLException, ClassNotFoundException {
        try {
             scanner = new Scanner(System.in);
             random = new Random();
             customerRepository = new CustomerRepository();
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int add() {
        try{
        Customer customer;
        System.out.println("please insert your name");
        String name=scanner.next();
        System.out.println("please insert nationalId");
        String national = scanner.next();
        System.out.println("please set password");
        int password = scanner.nextInt();
        System.out.println("please insert your address");
        String address = scanner.next();
        int id = random.ints(4, 100, 200).findFirst().getAsInt();
        customer = new Customer(id,name,national,password,"CUSTUMER",100,address);
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
        try {
        System.out.println("insert id");
        int id = scanner.nextInt();
        return customerRepository.delete(id);
    }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

}
public void showInfo(){
        Customer customer;
    try {
         customer = customerRepository.showinfo(id);
        System.out.println(customer);
     //   customer.tring();
    }catch (Exception e){
        e.printStackTrace();
    }}
public void addBuget(){
        try {
            System.out.println("please insert budget");
            float budget = scanner.nextFloat();
            customerRepository.changeBudget(id,budget);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public float howMuch(){
        try {
            return customerRepository.HowMuchHave(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public void withdraw(float budget){
        try {
            customerRepository.wid(id,budget);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}




