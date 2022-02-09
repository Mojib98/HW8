import models.Category;
import models.CustomerBasket;
import models.Product;
import service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class menu {
    private int select;
    AdminService adminService ;
    CustomeServie customeServie ;
    Scanner scanner ;
    LoginService loginService ;
    private int id;
   private boolean istime ;
    ProductService productService;
    CustomerBasketService customerBasketService;
    SaleProductService saleProductService;
    CategoryService categoryService;

    public menu() throws SQLException, ClassNotFoundException {
        try {

        adminService = new AdminService();
        customeServie = new CustomeServie();
            scanner = new Scanner(System.in);
            loginService = new LoginService();
            saleProductService = new SaleProductService();
            categoryService = new CategoryService();
            istime = false;

    }catch (SQLException e
        ){
            e.printStackTrace();
        }

    }

    public void menu() throws SQLException {
    while (true){
        System.out.println("for sing up insert 1\n " +
                "for login insert 2");
        try{
        select = scanner.nextInt();
        if (select == 1){
            singUp();
        }
         if (select == 2){
            boolean t=login();
            System.out.println(t);
            System.out.println(id);
                if (t){
                    istime=t;
                    if (this.id < 100){
                        admin();
                    }
                    else
                        customer();
                }

        }


    }catch (Exception e){
        e.printStackTrace();
        continue;

        }
    }}
    private void singUp() throws SQLException {
        System.out.println("if amin insert 1 else insert 2");
        int s = scanner.nextInt();
        if (s == 1) {
            adminService.add();
        } else
            customeServie.add();
    }
    private boolean login() throws SQLException {
        System.out.println("please insert your id");
        this.id = scanner.nextInt();
        System.out.println("please insert your password");
        int password=scanner.nextInt();
        return loginService.isHere(this.id,password);
    }
    private void admin(){
        while (istime){
            productService = new ProductService();
        System.out.println("for insert produce insert 1\n" +
                "for see all customer insert 2\n" +
                "for delete your product insert 3\n" +
                "for insert category insert 4\n" +
                "for see all category insert 5\n" +
                "for delete category insert 6\n" +
                "for exit insert 7");
        int select = scanner.nextInt();
        switch (select){
            case 1:
                productService.setAdminId(this.id);
                productService.add();
                break;
            case 2:
                productService.findAll();
                break;
            case 3:
                productService.delete();
                break;
            case 4:
                categoryService.add();

            case 5:
                categoryService.showAll();
                break;
            case 6:
                System.out.println("enter id");
                int cat=scanner.nextInt();
                categoryService.delete(cat);
                break;
            case 7:
                istime =false;
            default:
                continue;
        }
    }}

    private void customer() throws SQLException {

        try {
            CustomerBasketService customerBasketService = new CustomerBasketService();
            productService = new ProductService();
            customerBasketService.setCustomerId(this.id);
            customeServie.setId(this.id);
            while (istime){
            System.out.println("for buy insert 1\n" +
                    "for see by category insert 2\n" +
                    "for see your basket insert 3\n" +
                    "for final sale insert 4\n" +
                    "for delete from basket insert 5\n" +
                    "for add budget insert 6\n" +
                    "for see information insert 7" +
                    "for  cancel insert 8 ");
            List<CustomerBasket> list = null;
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    productService.showAllproduct();
                    customerBasketService.add();
                    break;
                case 2:
                    categoryService.showAll();
                    System.out.println("select category");
                    int category = scanner.nextInt();
                    productService.showByCategory(category);
                    break;
                case 3:
                    customerBasketService.show();
                   break;
                case 4:
                    float my=customeServie.howMuch();
                    float price=customerBasketService.getTotalPrice();
                   //System.out.println(Float.compare(my,price)+" "+my+"how "+price);
                    if (Float.compare(my,price) < 0){
                        customeServie.withdraw(price);
                    list = customerBasketService.findAll();
                    saleProductService.add(list);
                    customerBasketService.deleteFromBasket();
                    }
                    else
                        System.out.println("you dont have mony");
                    break;
                case 5:
                    customerBasketService.delete();
                    break;
                case 6:
                    customeServie.addBuget();
                    break;
                case 7:
                    customeServie.showInfo();
                    break;
                case 8:
                    customerBasketService.deleteFromBasket();
                    istime =false;
                    break;
                default:
                    continue;
            }
        }
    }catch (Exception e){
            e.printStackTrace();
        }
}}
