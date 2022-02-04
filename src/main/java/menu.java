import service.AdminService;
import service.CustomeServie;

import java.sql.SQLException;
import java.util.Scanner;

public class menu {
    private int select;
    AdminService adminService = new AdminService();
    CustomeServie customeServie = new CustomeServie();
    Scanner scanner = new Scanner(System.in);

    public menu() throws SQLException, ClassNotFoundException {
    }

    public void menu() throws SQLException {
        System.out.println("for sing up insert 1\n " +
                "for login insert 2");
        select = scanner.nextInt();
        if (select == 1){
            singUp();
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
}
