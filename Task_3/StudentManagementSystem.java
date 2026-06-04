import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    // Database Details
    static final String URL = "jdbc:postgresql://localhost:5432/Student_DB";
    static final String USER = "postgres";
    static final String PASSWORD = "Harshdeep@11";

    static Scanner sc = new Scanner(System.in);

    // Database Connection
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add Student
    public static void addStudent() {
        try {
            Connection con = getConnection();

            String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setInt(4, sem);
            ps.setDouble(5, cgpa);
            ps.setString(6, email);
            ps.setString(7, city);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // View Students
    public static void viewStudents() {
        try {
            Connection con = getConnection();

            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n--------------------------------------------------------------");
            System.out.println("ID\tName\tDept\tSem\tCGPA\tEmail\t\tCity");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + "\t" +
                        rs.getString(2) + "\t" +
                        rs.getString(3) + "\t" +
                        rs.getInt(4) + "\t" +
                        rs.getDouble(5) + "\t" +
                        rs.getString(6) + "\t" +
                        rs.getString(7)
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Student
    public static void updateStudent() {
        try {
            Connection con = getConnection();

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            String query = "UPDATE student SET name=?, dept=?, sem=?, cgpa=?, email=?, city=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter New Semester: ");
            int sem = sc.nextInt();

            System.out.print("Enter New CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter New Email: ");
            String email = sc.nextLine();

            System.out.print("Enter New City: ");
            String city = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, sem);
            ps.setDouble(4, cgpa);
            ps.setString(5, email);
            ps.setString(6, city);
            ps.setInt(7, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Student
    public static void deleteStudent() {
        try {
            Connection con = getConnection();

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}