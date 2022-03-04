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
    String nationalid;
    public int id;

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public AdminService() {
        try {

            adminRepository = new AdminRepository();
            scanner = new Scanner(System.in);
            random = new Random();
        } catch (SQLException e) {
            System.out.println("bad code in repository admin");
        } catch (Exception s) {
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
            admin = new Admin(id, name, nationalId, password, "ADMIN");
            return adminRepository.add(admin);
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
        } catch (Exception e) {
            System.out.println("bad code");
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
            int id = 0;
            System.out.println("plese insert new password");
            int password = scanner.nextInt();
            admin = new Admin(id, name, nationalId, password, "ADMIN");
            return adminRepository.update(admin);
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
        } catch (Exception e) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void showInfo(){
        try {
            this.admin =adminRepository.seeMyInfo(this.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(admin);
    }
}
















