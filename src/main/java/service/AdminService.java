package service;

import models.Admin;
import repository.AdminRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdminService implements Service<Admin> {
    AdminRepository adminRepository;
    Scanner scanner;
    Admin admin;
    Random random;

    public AdminService() {
        try {

            adminRepository = new AdminRepository();
            scanner = new Scanner(System.in);
            random = new Random();
        } catch (SQLException e) {
            System.out.println("bad code in repository admin");
        } catch (ClassNotFoundException s) {
            System.out.println("bad code in repository admin");
        }
    }

    @Override
    public int add() {
        try {
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
        } catch (SQLException e) {
            System.out.println("wrong in addin");
            return 0;
        } catch (Exception E) {
            E.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Admin> findAll() {
        try {
            List<Admin> list = adminRepository.findAll();
            for (Admin m : list
            ) {
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println("bad code");
            return null;
        }
        return null;
    }

    @Override
    public int update() {
        try {

            System.out.println("please insert name");
            String name = scanner.next();
            System.out.println("please insert nationalId");
            String nationalId = scanner.next();
            System.out.println("please insert password");
            int password = scanner.nextInt();
            System.out.println("please insert id");
            int id = scanner.nextInt();
            System.out.println("plese insert new password");
            admin = new Admin(id, name, nationalId, password, "ADMIN");
            return adminRepository.update(admin);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
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
/*
    public void addBudget() {
        try {

            System.out.println("plese insert id customer");
            int id = scanner.nextInt();
            System.out.println("please insert your buget");
            float buget = scanner.nextFloat();
            adminRepository.addBudget(id, buget);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
















