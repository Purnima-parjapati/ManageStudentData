package Main;

import Service.AdminService;
import Service.StudentService;
import exception.AuthenticationException;
import exception.StudentNotFoundException;
import Model.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminService();
        StudentService studentService = new StudentService();

        boolean loggedIn = false;

        while (true) {
            System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                try {
                    if (adminService.authenticate(username, password)) {
                        System.out.println("Login successful!\n");
                        loggedIn = true;
                    }
                } catch (AuthenticationException e) {
                    System.out.println("Login failed: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }

            // After login
            while (loggedIn) {
                System.out.println("\n===== Admin Menu =====");
                System.out.println("1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View Student by ID");
                System.out.println("5. View All Students");
                System.out.println("6. Logout");
                System.out.print("Enter choice: ");
                int adminChoice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (adminChoice) {
                    case 1:
                        Student newStudent = new Student();

                        System.out.print("First Name: ");
                        newStudent.setFirstName(sc.nextLine());

                        System.out.print("Last Name: ");
                        newStudent.setLastName(sc.nextLine());

                        System.out.print("Date of Birth (DD-MM-YYYY): ");
                        newStudent.setDateOfBirth(sc.nextLine());

                        System.out.print("Gender: ");
                        newStudent.setGender(sc.nextLine());

                        System.out.print("Email: ");
                        newStudent.setEmail(sc.nextLine());

                        System.out.print("Phone: ");
                        newStudent.setPhone(sc.nextLine());

                        System.out.print("Course: ");
                        newStudent.setCourse(sc.nextLine());

                        System.out.print("Enrollment ID: ");
                        newStudent.setEnrollmentID(sc.nextLine());

                        studentService.registerStudent(newStudent);  // call to DAO via service
                        System.out.println("✅ Student added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Student ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine(); // consume newline

                        try {
                            Student studentToUpdate = studentService.getStudentByID(updateId);

                            System.out.print("First Name (" + studentToUpdate.getFirstName() + "): ");
                            studentToUpdate.setFirstName(sc.nextLine());

                            System.out.print("Last Name (" + studentToUpdate.getLastName() + "): ");
                            studentToUpdate.setLastName(sc.nextLine());

                            System.out.print("DOB (" + studentToUpdate.getDateOfBirth() + "): ");
                            studentToUpdate.setDateOfBirth(sc.nextLine());

                            System.out.print("Gender (" + studentToUpdate.getGender() + "): ");
                            studentToUpdate.setGender(sc.nextLine());

                            System.out.print("Phone (" + studentToUpdate.getPhone() + "): ");
                            studentToUpdate.setPhone(sc.nextLine());

                            System.out.print("Course (" + studentToUpdate.getCourse() + "): ");
                            studentToUpdate.setCourse(sc.nextLine());

                            System.out.print("Enrollment ID (" + studentToUpdate.getEnrollmentID() + "): ");
                            studentToUpdate.setEnrollmentID(sc.nextLine());

                            studentService.updateStudent(studentToUpdate);
                            System.out.println("✅ Student updated successfully!");

                        } catch (StudentNotFoundException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to delete: ");
                        int delID = sc.nextInt();
                        sc.nextLine();

                        try {
                            studentService.deleteStudent(delID);
                            System.out.println("✅ Student deleted successfully.");
                        } catch (StudentNotFoundException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Enter Student ID to search: ");
                        int searchID = sc.nextInt();
                        sc.nextLine(); // consume newline
                        try {
                            Student found = studentService.getStudentByID(searchID);
                            printStudent(found);
                        } catch (StudentNotFoundException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                        break;


                    case 5:
                        List<Student> allStudents = studentService.getAllStudent();
                        for (Student s : allStudents) {
                            printStudent(s);
                        }
                        break;

                    case 6:
                        loggedIn = false;
                        System.out.println("Logged out successfully.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        sc.close();
    }

    private static void printStudent(Student s) {
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + s.getStudentID());
        System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
        System.out.println("DOB: " + s.getDateOfBirth());
        System.out.println("Gender: " + s.getGender());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Phone: " + s.getPhone());
        System.out.println("Course: " + s.getCourse());
        System.out.println("Enrollment ID: " + s.getEnrollmentID());
    }
}
