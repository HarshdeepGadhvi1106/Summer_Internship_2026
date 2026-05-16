import java.util.*;

class Employee {
    String name;
    int id;
    double salary;
    String department;
    String designation;

    Employee(int id, String name, String department,String designation ,double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
    }
}

public class Task_1 {
  
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Employee Management System App : ");
        System.out.println("===========================================");
      


        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employees");
            System.out.println("4. Delete Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Employee newEmployee = new Employee(id, name, department, designation, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!");
        System.out.println("-----------------------");
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (Employee emp : employees) {
            emp.display();
            System.out.println("-----------------------");
        }
    }

   static void updateEmployee(Scanner scanner) {
    System.out.print("Enter Employee ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    for (Employee emp : employees) {

        if (emp.id == id) {

            System.out.println("Employee found. Enter new details:");

            System.out.print("Enter Employee Name: ");
            emp.name = scanner.nextLine();

            System.out.print("Enter Employee Department: ");
            emp.department = scanner.nextLine();

            System.out.print("Enter Employee Designation: ");
            emp.designation = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            emp.salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Employee updated successfully!");
            System.out.println("-----------------------");

            return;
        }
    }

    System.out.println("Employee not found.");
}

    static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

}