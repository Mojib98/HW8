import service.AdminService;
import service.CustomeServie;
import service.LoginService;
import service.ProductService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminService admin =new AdminService();
       // CustomeServie customeServie = new CustomeServie();
       //customeServie.add();
       // LoginService loginService = new LoginService();
       // System.out.println(loginService.isHere(2,33));
        ProductService p = new ProductService();
        p.giveproduce(0,2);
    }
}
