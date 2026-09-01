package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionExample {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/studentdb";

        String username = "root";
        String password = "Root@123";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            System.out.println(
                    "Database connected successfully!"
            );

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}