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
            
            int choice = readInt(scanner, "Enter your choice: ");

            if (choice == 1) {
                int id = readInt(scanner, "Enter ID: ");
                if (manager.exists(id)) {
                    System.out.println("Error: A student with ID " + id + " already exists!");
                    continue;
                }
                
                String name = readString(scanner, "Enter Name: ");
                int age = readInt(scanner, "Enter Age: ");
                String course = readString(scanner, "Enter Course: ");
                
                Student student = new Student(id, name, age, course);
                manager.addStudent(student);
                
            } else if (choice == 2) {
                manager.viewAllStudents();
                
            } else if (choice == 3) {
                int id = readInt(scanner, "Enter ID to search: ");
                manager.searchStudent(id);
                
            } else if (choice == 4) {
                int id = readInt(scanner, "Enter ID to delete: ");
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

    // Helper to read an integer with error handling
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer number.");
            }
        }
    }

    // Helper to read a non-empty string
    private static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
