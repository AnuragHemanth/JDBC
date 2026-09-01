package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchExample {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/studentdb";

        String username = "root";
        String password = "Root@123";

        int studentId = 2;

        String sql =
                "SELECT * FROM students WHERE id = ?";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "ID: " +
                                rs.getInt("id")
                );

                System.out.println(
                        "Name: " +
                                rs.getString("name")
                );

                System.out.println(
                        "Age: " +
                                rs.getInt("age")
                );

            } else {

                System.out.println(
                        "Student not found"
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}