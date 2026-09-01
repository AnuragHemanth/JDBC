package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

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
                    "SELECT * FROM students";

            ResultSet rs =
                    st.executeQuery(sql);

            while (rs.next()) {

                int id =
                        rs.getInt("id");

                String name =
                        rs.getString("name");

                int age =
                        rs.getInt("age");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}