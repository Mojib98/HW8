import models.CustomerBasket;
import models.Product;
import service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class menu {
    private int select;
    AdminService adminService = new AdminService();
    CustomeServie customeServie = new CustomeServie();
    Scanner scanner = new Scanner(System.in);
    LoginService loginService = new LoginService();
    private int id;
    boolean istime = false;
    ProductService productService;
    CustomerBasketService customerBasketService;
    SaleProductService saleProductService = new SaleProductService();

    public menu() throws SQLException, ClassNotFoundException {
    }

    public void menu() throws SQLException {

        System.out.println("for sing up insert 1\n " +
                "for login insert 2");
        select = scanner.nextInt();
        if (select == 1){
            singUp();
        }
        else {
                if (login()){
                    if (this.id>100){
                        admin();
                    }
                    else
                        customer();
                }

        }


    }
    private void singUp() throws SQLException {
        System.out.println("if amin insert 1 else insert 2");
        int s = scanner.nextInt();
        if (s == 1) {
            adminService.add();
        } else
            customeServie.add();
    }
    private boolean login() throws SQLException {
        System.out.println("plese insert your id");
        this.id = scanner.nextInt();
        System.out.println("plese insert your password");
        int password=scanner.nextInt();
        return loginService.isHere(this.id,password);
    }
    private void admin(){
        while (istime){
            productService = new ProductService();
        System.out.println("for insert produce insert 1/n" +
                "for see all customer insert 2");
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
                istime =false;
        }
    }}

    private void customer() throws SQLException {
        while (istime){
            System.out.println("for sell insert 1\n" +
                    "for see your basket insert 2\n" +
                    "for final sale insert 3\n" +
                    "for delete from basket insert 4\n" +
                    "for exit insert  or cancell 4");
            List<CustomerBasket> list = null;
            int select = scanner.nextInt();
            customerBasketService.setCustomerId(this.id);
            switch (select){
                case 1:
                    productService.findAll();
                    customerBasketService.add();
                    break;
                case 2:
                    productService.findAll();
                   break;
                case 3:
                    list = customerBasketService.findAll();
                    saleProductService.add(list);
                case 4:
                case 5:
                    istime =false;
            }
        }
    }
}
