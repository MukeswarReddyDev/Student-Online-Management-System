package sms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("______SYSTEM MENU______");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                System.out.print("Enter Course: ");
                String course = scanner.nextLine();
                
                Student student = new Student(id, name, age, course);
                manager.addStudent(student);
                
            } else if (choice == 2) {
                manager.viewAllStudents();
                
            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = scanner.nextInt();
                manager.searchStudent(id);
                
            } else if (choice == 4) {
                System.out.print("Enter ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteStudent(id);
                
            } else if (choice == 5) {
                System.out.println("Exiting the System. Goodbye!");
                break; // Exit the loop
                
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        
        scanner.close();
    }
}
