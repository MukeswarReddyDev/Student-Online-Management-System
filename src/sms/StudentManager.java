package sms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {
    private static final String FILE_PATH = "students.txt";
    // We use a simple ArrayList to hold the students
    private ArrayList<Student> students = new ArrayList<>();

    // Constructor to load students from file
    public StudentManager() {
        loadFromFile();
    }

    // Check if a student with the given ID already exists
    public boolean exists(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // 1. Add Student
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }

    // 2. View All Students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        // Simple loop to print every student
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.toString());
        }
    }

    // 3. Search Student by ID
    public void searchStudent(int searchId) {
        // Loop through all students to find the match
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId() == searchId) {
                System.out.println("Student Found: " + s.toString());
                return; // Stop looking because we found the student
            }
        }
        System.out.println("Student not found.");
    }

    // 4. Delete Student
    public void deleteStudent(int deleteId) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId() == deleteId) {
                students.remove(i);
                saveToFile();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Load students from a local file
    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        int age = Integer.parseInt(parts[2]);
                        String course = parts[3];
                        students.add(new Student(id, name, age, course));
                    } catch (NumberFormatException e) {
                        // Skip malformed records
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading student records: " + e.getMessage());
        }
    }

    // Save students to a local file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                writer.write(s.getId() + ";" + s.getName() + ";" + s.getAge() + ";" + s.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student records: " + e.getMessage());
        }
    }
}
