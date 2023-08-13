import java.io.*;
import java.util.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Name;
    private int RollNumber;
    private String Grade;

    public Student(String Name, int RollNumber, String Grade) {
        this.Name = Name;
        this.RollNumber = RollNumber;
        this.Grade = Grade;
    }

    public String get_Name() {
        return Name;
    }

    public int get_RollNumber() {
        return RollNumber;
    }

    public String get_Grade() {
        return Grade;
    }

    @Override
    public String toString() {
        return "Name: " + Name + ", Roll Number: " + RollNumber + ", Grade: " + Grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void AddStudent(Student student) {
        students.add(student);
    }

    public boolean RemoveStudent(int RollNumber) {
        for (Student student : students) {
            if (student.get_RollNumber() == RollNumber) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student SearchStudent(int RollNumber) {
        for (Student student : students) {
            if (student.get_RollNumber() == RollNumber) {
                return student;
            }
        }
        return null;
    }

    public void DisplayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\n___________ Student Management System ____________");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int RollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String Grade = scanner.nextLine();
                    Student newStudent = new Student(Name, RollNumber, Grade);
                    system.AddStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    if (system.RemoveStudent(removeRollNumber)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int SearchRollNumber = scanner.nextInt();
                    Student foundStudent = system.SearchStudent(SearchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All students:");
                    system.DisplayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
