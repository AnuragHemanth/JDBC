package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {

    static String url =
            "jdbc:mysql://localhost:3306/studentdb";

    static String username = "root";
    static String password = "Root@123";


    // CREATE
    static void addStudent(String name, int age) {

        String sql =
                "INSERT INTO students (name, age) VALUES (?, ?)";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " student added"
            );

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // READ
    static void getStudents() {

        String sql =
                "SELECT * FROM students";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

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
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // UPDATE
    static void updateStudent(int id, int newAge) {

        String sql =
                "UPDATE students SET age = ? WHERE id = ?";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, newAge);
            ps.setInt(2, id);

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " student updated"
            );

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // DELETE
    static void deleteStudent(int id) {

        String sql =
                "DELETE FROM students WHERE id = ?";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " student deleted"
            );

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // MAIN
    public static void main(String[] args) {

        System.out.println("---- CREATE ----");

        addStudent("Rahul", 21);
        addStudent("Priya", 22);


        System.out.println("\n---- READ ----");

        getStudents();


        System.out.println("\n---- UPDATE ----");

        updateStudent(1, 25);


        System.out.println("\n---- READ AFTER UPDATE ----");

        getStudents();


        System.out.println("\n---- DELETE ----");

        deleteStudent(2);


        System.out.println("\n---- READ AFTER DELETE ----");

        getStudents();
    }
}