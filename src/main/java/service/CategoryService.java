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
    Scanner scanner = new Scanner(System.in);
    PreparedStatement preparedStatement;
    Random random = new Random();
    Category category;
    CategoryRepository categoryRepository = new CategoryRepository();

    public CategoryService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public int add() throws SQLException {
        System.out.println("Plese insert brandId");
        int brand =scanner.nextInt();
        System.out.println("insert your name");
        String name = scanner.next();
        int id = random.ints(4, 10, 99).findFirst().getAsInt();
        category = new Category(brand,name);
        categoryRepository.add(category);
        return 0;
    }
    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> list=new ArrayList<Category>();

       list= categoryRepository.findAll();
        for (Category c:list
             ) {
            System.out.print(c.getId() +" ");
            System.out.print(c.getName());
            System.out.println();
        }
        return null;
    }

    @Override
    public int update() throws SQLException {
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("please insert your id");
            return 0;
    }
}
