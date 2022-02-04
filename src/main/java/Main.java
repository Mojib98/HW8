import service.AdminService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminService admin =new AdminService();

       admin.add();
    }
}
