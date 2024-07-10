
import java.util.ArrayList;
import java.util.Scanner;

// Class representing a student
class Student {

    String name;
    int id;
    int age;
    char grade;

    Student(String name, int id, int age, char grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }
}

// Class for student management operations
class StudentManagement {

    static ArrayList<Student> studentList = new ArrayList<>();
    static int totalStudents = 0;

    // Method to add a new student
    public static void addStudent(String name, int id, int age, char grade) {
        studentList.add(new Student(name, id, age, grade));
        totalStudents++;
        System.out.println("Student added successfully.");
    }

    // Method to update student information
    public static void updateStudent(int id, String name, int age, char grade) {
        for (Student student : studentList) {
            if (student.id == id) {
                student.name = name;
                student.age = age;
                student.grade = grade;
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to view student details
    public static void viewStudent(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.println("Name: " + student.name);
                System.out.println("ID: " + student.id);
                System.out.println("Age: " + student.age);
                System.out.println("Grade: " + student.grade);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

// Main class with the administrator interface
public class StudentRecordManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    StudentManagement.addStudent(name, id, age, grade);
                    break;
                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    char newGrade = scanner.next().charAt(0);
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter ID of the student to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
