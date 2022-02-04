package service;

import models.Admin;
import repository.AdminRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdminService implements Service<Admin> {
    AdminRepository adminRepository = new AdminRepository();
    Scanner scanner = new Scanner(System.in);
    Admin admin;
    Random random = new Random();

    public AdminService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add() throws SQLException {
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println();
        System.out.println("please insert nationalId");
        String nationalId = scanner.next();
        System.out.println();
        System.out.println("please insert password");
        int password = scanner.nextInt();
        int id = random.ints(4, 10, 99).findFirst().getAsInt();
        admin = new Admin(id, name, nationalId, password, "ADMIN");
        return adminRepository.add(admin);
    }

    @Override
    public List<Admin> findAll() {
        try {
            List<Admin> list= adminRepository.findAll();
            list.toString();
            for (Admin m:list
                 ) {
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public int update() throws SQLException {
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert nationalId");
        String nationalId = scanner.next();
        System.out.println("please insert password");
        int password = scanner.nextInt();
        System.out.println("please insert id");
        int id = scanner.nextInt();
        System.out.println("plese insert new password");
        admin = new Admin(id,name,nationalId,password,"ADMIN");
        return adminRepository.update(admin);
    }

    @Override
    public int delete() {
        try {
            System.out.println("please insert your Id");
            int id = scanner.nextInt();
            return adminRepository.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public void addBudget() throws SQLException {
        System.out.println("plese insert id customer");
        int id = scanner.nextInt();
        System.out.println("please insert your buget");
        float buget = scanner.nextFloat();
        adminRepository.addBudget(id,buget);
    }

}
