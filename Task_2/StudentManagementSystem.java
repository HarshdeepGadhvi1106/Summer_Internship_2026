import java.io.*;
import java.util.Scanner;

class StudentManagementSystem {

    static final String FILE_NAME = "student_data.csv";

    // Create File With Columns
    public static void createFileIfNotExists() {

        File file = new File(FILE_NAME);

        try {

            if (file.createNewFile()) {

                FileWriter fw = new FileWriter(FILE_NAME);

                // Column Names
                fw.write("ID,Name,Dept,Sem,CGPA,Email,City\n");

                fw.close();

                System.out.println("=================================");
                System.out.println(" File Created Successfully ");
                System.out.println(" File Name : " + FILE_NAME);
                System.out.println("=================================");
            }

        } catch (IOException e) {

            System.out.println("Error Creating File");
        }
    }

    // Add Student
    public static void addStudent() {

        Scanner sc = new Scanner(System.in);

        try {

            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            // Save Data
            bw.write(id + "," + name + "," + dept + "," +
                     sem + "," + cgpa + "," +
                     email + "," + city);

            bw.newLine();

            bw.close();

            System.out.println("Student Added Successfully!");

        } catch (IOException e) {

            System.out.println("Error Writing File");
        }
    }

    // View Students
    public static void viewStudents() {

        try {

            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n===== Student Records =====");

            // Skip Header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println("ID      : " + data[0]);
                System.out.println("Name    : " + data[1]);
                System.out.println("Dept    : " + data[2]);
                System.out.println("Sem     : " + data[3]);
                System.out.println("CGPA    : " + data[4]);
                System.out.println("Email   : " + data[5]);
                System.out.println("City    : " + data[6]);

                System.out.println("---------------------------");
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No Records Found!");
        }
    }

    // Search Student
    public static void searchStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID To Search: ");
        String searchId = sc.nextLine();

        boolean found = false;

        try {

            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;

            // Skip Header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                if (data[0].equals(searchId)) {

                    System.out.println("\nStudent Found!");
                    System.out.println("ID      : " + data[0]);
                    System.out.println("Name    : " + data[1]);
                    System.out.println("Dept    : " + data[2]);
                    System.out.println("Sem     : " + data[3]);
                    System.out.println("CGPA    : " + data[4]);
                    System.out.println("Email   : " + data[5]);
                    System.out.println("City    : " + data[6]);

                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {

                System.out.println("Student Not Found!");
            }

        } catch (IOException e) {

            System.out.println("Error Reading File");
        }
    }

    // Remove Student
    public static void removeStudent() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID To Remove: ");
        String removeId = sc.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.csv");

        boolean found = false;

        try {

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            // Copy Header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                if (!data[0].equals(removeId)) {

                    bw.write(line);
                    bw.newLine();

                } else {

                    found = true;
                }
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {

                System.out.println("Student Removed Successfully!");

            } else {

                System.out.println("Student Not Found!");
            }

        } catch (IOException e) {

            System.out.println("Error Removing Student");
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        createFileIfNotExists();

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    System.out.println("Program Exited");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}