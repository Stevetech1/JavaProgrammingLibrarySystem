import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a student with basic information
class Student {
    String name;
    int id;
    int age;
    char grade;

    // Constructor to initialize a new student object
    public Student(String name, int id, int age, char grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Override toString method to display student information
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

// Class to manage student records
class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>(); // List to store student objects
    private static int totalStudents = 0; // Counter for total number of students

    // Method to add a new student to the list
    public static void addStudent(String name, int id, int age, char grade) {
        Student newStudent = new Student(name, id, age, grade); // Create a new student object
        studentList.add(newStudent); // Add the student to the list
        totalStudents++; // Increment the total number of students
        System.out.println("Student added successfully."); // Confirm addition
    }

    // Method to update an existing student's information
    public static void updateStudent(int id, String newName, int newAge, char newGrade) {
        for (Student student : studentList) { // Iterate over the student list
            if (student.id == id) { // Check if the current student matches the given ID
                student.name = newName; // Update name
                student.age = newAge; // Update age
                student.grade = newGrade; // Update grade
                System.out.println("Student updated successfully."); // Confirm update
                return;
            }
        }
        System.out.println("Student ID not found."); // Inform if student ID not found
    }

    // Method to view a student's details by ID
    public static void viewStudent(int id) {
        for (Student student : studentList) { // Iterate over the student list
            if (student.id == id) { // Check if the current student matches the given ID
                System.out.println(student); // Display student information
                return;
            }
        }
        System.out.println("Student ID not found."); // Inform if student ID not found
    }

    // Method to view all students' details
    public static void viewAllStudents() {
        if (studentList.isEmpty()) { // Check if the student list is empty
            System.out.println("No students available."); // Inform if no students
            return;
        }
        for (Student student : studentList) { // Iterate over the student list
            System.out.println(student); // Display each student's information
        }
    }

    // Method to display the menu options
    public static void displayMenu() {
        System.out.println("Student Record Management System");
        System.out.println("1. Add a new student");
        System.out.println("2. Update student information");
        System.out.println("3. View student details");
        System.out.println("4. View all students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}

// Main class to run the student record management system
public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        while (true) { // Infinite loop to keep the program running until user chooses to exit
            StudentManagement.displayMenu(); // Display the menu options
            int choice = scanner.nextInt(); // Read the user's menu choice
            scanner.nextLine(); // Consume the newline character

            // Switch case to handle different menu choices
            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    StudentManagement.addStudent(name, id, age, grade);
                    break;
                case 2:
                    // Update an existing student's information
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    char newGrade = scanner.next().charAt(0);
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    // View a student's details by ID
                    System.out.print("Enter student ID to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    // View all students' details
                    StudentManagement.viewAllStudents();
                    break;
                case 5:
                    // Exit the system
                    System.out.println("Exiting the system.");
                    scanner.close(); // Close the scanner
                    return; // Exit the main method
                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
