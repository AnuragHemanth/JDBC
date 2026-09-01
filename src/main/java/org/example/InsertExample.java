package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExample {

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

            Statement st =
                    con.createStatement();

            String sql =
                    "INSERT INTO students (name, age) " +
                            "VALUES ('Rahul', 21)";

            int rows =
                    st.executeUpdate(sql);

            System.out.println(
                    rows + " student inserted"
            );

            st.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}