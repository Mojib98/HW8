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
        System.out.println("please insert nationalId");
        String nationalId = scanner.next();
        System.out.println("please insert password");
        int password = scanner.nextInt();
        int id = random.ints(4, 10, 99).findFirst().getAsInt();
        admin = new Admin(id, name, nationalId, password, "ADMIN");
        return adminRepository.add(admin);
    }

    @Override
    public List<Admin> findAll() {
        try {
            return adminRepository.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update() {
        System.out.println("plese insert new password");
        admin = new Admin();
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
}
