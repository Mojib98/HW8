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

    public menu() throws SQLException, ClassNotFoundException {
        try {

        adminService = new AdminService();
        customeServie = new CustomeServie();
            scanner = new Scanner(System.in);
            loginService = new LoginService();
            saleProductService = new SaleProductService();
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
                "for exit insert 4");
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
                istime =false;
            default:
                continue;
        }
    }}

    private void customer() throws SQLException {

        try {
            CustomerBasketService customerBasketService = new CustomerBasketService();

            while (istime){
            System.out.println("for buy insert 1\n" +
                    "for see your basket insert 2\n" +
                    "for final sale insert 3\n" +
                    "for delete from basket insert 4\n" +
                    "for  cancel insert 5 ");
            List<CustomerBasket> list = null;
            int select = scanner.nextInt();
            productService = new ProductService();
            customerBasketService.setCustomerId(this.id);
            switch (select){
                case 1:
                    productService.showAllproduct();
                    customerBasketService.add();
                    break;
                case 2:
                    customerBasketService.show();
                   break;
                case 3:
                    list = customerBasketService.findAll();
                    saleProductService.add(list);
                    customerBasketService.deleteFromBasket();
                    break;
                case 4:
                    customerBasketService.delete();
                    break;
                case 5:
                    customerBasketService.deleteFromBasket();
                    istime =false;
            }
        }
    }catch (Exception e){
            e.printStackTrace();
        }
}}
