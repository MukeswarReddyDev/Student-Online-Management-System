# 🎓 Online Student Management System

A **console-based Student Management System** built in Java using Collections (ArrayList). It allows you to manage student records with full **CRUD operations** and automatic **data persistence** across sessions.

---

## 📋 Features

| Feature | Description |
|---|---|
| ➕ Add Student | Register a new student with ID, Name, Age, and Course |
| 📋 View All Students | Display all registered students in a formatted table |
| 🔍 Search Student | Find a student by their unique ID |
| ❌ Delete Student | Remove a student from the system by their ID |
| 💾 Data Persistence | Records are automatically saved to a local file and loaded on startup |
| 🛡️ Input Validation | Handles invalid inputs gracefully without crashing |
| 🚫 Duplicate ID Check | Prevents two students from having the same ID |

---

## 🛠️ Tech Stack

- **Language**: Java (JDK 8+)
- **Data Storage**: Collections (`ArrayList`) + File I/O (`BufferedReader` / `BufferedWriter`)
- **Interface**: Console / Terminal

---

## 🗂️ Project Structure

```
src/
└── sms/
    ├── Student.java         # Model class for student data
    ├── StudentManager.java  # Business logic: CRUD + file persistence
    └── Main.java            # Entry point with menu-driven UI
```

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or above installed
- Command line / Terminal

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/MukeswarReddyDev/Student-Online-Management-System.git
cd Student-Online-Management-System
```

**2. Compile the source files**
```bash
mkdir bin
javac -d bin src/sms/*.java
```

**3. Run the application**
```bash
java -cp bin sms.Main
```

---

## 📷 Sample Output

```
______SYSTEM MENU______
1. Add Student
2. View All Students
3. Search Student
4. Delete Student
5. Exit
Enter your choice: 2

ID: 101   | Name: Alice Cooper         | Age: 21  | Course: Physics
ID: 102   | Name: Bob Ross             | Age: 22  | Course: Art
```

---

## 🧠 Key Concepts Used

- **OOP Principles** — Encapsulation using `private` fields and public getters/setters
- **Java Collections** — `ArrayList` for dynamic student list management
- **File I/O** — `BufferedReader` and `BufferedWriter` for persistent data storage
- **Exception Handling** — `try-catch` blocks to handle invalid user inputs robustly

---

## 👨‍💻 Author

**Mukeswar Reddy**  
[GitHub](https://github.com/MukeswarReddyDev)
