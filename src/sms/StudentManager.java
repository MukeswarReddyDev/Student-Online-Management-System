package sms;

import java.util.ArrayList;

public class StudentManager {
    // We use a simple ArrayList to hold the students
    private ArrayList<Student> students = new ArrayList<>();

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
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
