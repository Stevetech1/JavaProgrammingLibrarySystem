import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    int age;
    char grade;

    public Student(String name, int id, int age, char grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    public static void addStudent(String name, int id, int age, char grade) {
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        totalStudents++;
        System.out.println("Student added successfully.");
    }

    public static void updateStudent(int id, String newName, int newAge, char newGrade) {
        for (Student student : studentList) {
            if (student.id == id) {
                student.name = newName;
                student.age = newAge;
                student.grade = newGrade;
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public static void viewStudent(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

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

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            StudentManagement.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
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
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    char newGrade = scanner.next().charAt(0);
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter student ID to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    StudentManagement.viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
