package service;

import models.Category;
import repository.CategoryRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CategoryService implements Service<Category> {

    private Scanner scanner;
    private PreparedStatement preparedStatement;
    private Random random;
    private Category category;
    private CategoryRepository categoryRepository;

    public CategoryService() throws SQLException, ClassNotFoundException {
        try {
            scanner = new Scanner(System.in);
            random = new Random();
            categoryRepository = new CategoryRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add() {
        try {
          //  System.out.println("Plese insert brandId");
            ///int brand = scanner.nextInt();
            System.out.println("insert your name");
            String name = scanner.next();
            int id = random.ints(4, 10, 99).findFirst().getAsInt();
            category = new Category(id, name);
            categoryRepository.add(category);
            return 0;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<Category>();
        try {
        list = categoryRepository.findAll();
        for (Category c : list
        ) {
            System.out.print(c.getId() + " ");
            System.out.print(c.getName());
            System.out.println();
        }
        return null;
    } catch (Exception e){
            e.printStackTrace();
            return null;
        }}

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("please insert your id");
        return 0;

    }
    public void showAll(){
        List<Category> list = new ArrayList<Category>();
        try {

        list=categoryRepository.findAll();
        for (Category c:list){
            System.out.println(c);
        }
    }catch (Exception e){
        e.printStackTrace();}
    }
    public void delete(int id){
        try {
            categoryRepository.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
