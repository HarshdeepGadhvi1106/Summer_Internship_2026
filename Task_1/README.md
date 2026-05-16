# Employee Management System

This project is a simple Java-based Employee Management System using ArrayList, Iterator, Classes, Objects, and Scanner.  
It allows users to Add, Display, Update, and Delete employee records through a menu-driven program.

---

# Problem Statement

Develop a console-based Employee Management System in Java to manage employee records efficiently.  
The system should perform CRUD operations (Create, Read, Update, Delete) using ArrayList and Object-Oriented Programming concepts.

---

# Features

- Add Employee
- Display All Employees
- Update Employee Details
- Delete Employee
- Menu Driven Program
- Uses ArrayList Collection
- Uses Iterator for Safe Deletion

---

# Technologies Used

- Java
- ArrayList
- Iterator
- Scanner Class
- OOP Concepts

----

# Workflow of Employee Management System

## 1. Program Initialization
The program starts from the `main()` method. A `Scanner` object is created to take input from the user, and an `ArrayList<Employee>` is initialized to store employee records dynamically.

---

## 2. Displaying Menu
A `while(true)` loop is used to repeatedly display the menu options such as Add Employee, Display Employees, Update Employee, Delete Employee, and Exit until the user chooses to terminate the program.

---

## 3. Reading User Choice
The program reads the user's choice using `scanner.nextInt()` and executes the corresponding operation using the `switch-case` statement.

---

## 4. Adding Employee
When the user selects Add Employee:
- The program asks for employee details like ID, Name, Department, Designation, and Salary.
- A new `Employee` object is created using the constructor.
- The object is stored inside the `ArrayList` using `employees.add()`.

This operation dynamically stores employee records in memory.

---

## 5. Displaying Employees
When the user selects Display Employees:
- The program first checks whether the `ArrayList` is empty.
- If records exist, a for-each loop traverses the list.
- The `display()` method of each employee object is called to print employee details.

This operation shows all stored employee records.

---

## 6. Updating Employee
When the user selects Update Employee:
- The program asks for the employee ID.
- A loop searches for the matching employee object.
- If the employee is found, new details are taken from the user.
- Existing object values are updated directly.

This operation modifies employee information without removing the object from the `ArrayList`.

---

## 7. Deleting Employee
When the user selects Delete Employee:
- The program asks for the employee ID.
- An `Iterator` is used to traverse the `ArrayList`.
- If a matching employee is found, `iterator.remove()` deletes the object safely.

Iterator is used to avoid `ConcurrentModificationException`.

---

## 8. Exiting Program
When the user selects Exit:
- The program displays the exit message.
- `scanner.close()` is called.
- The program terminates using `return`.

---

## 9. Overall Working
The complete system works as a CRUD (Create, Read, Update, Delete) application where employee records are managed dynamically using Java Collection Framework and Object-Oriented Programming concepts.