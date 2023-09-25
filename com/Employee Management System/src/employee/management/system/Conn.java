package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conn {



    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String dataBaseUrl = "jdbc:mysql://localhost:3306/details";
                String username = "root";
                String password = "";
                Class.forName(driver);

                Connection con = DriverManager.getConnection(dataBaseUrl,username,password);
                return con;

            } catch (Exception e) {
                e.fillInStackTrace();
            }
            return null;
        }
    }
