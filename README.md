# 📚 Library Management System (Java)

A console-based library management system built using Java with modular OOP design. It supports basic operations for **Admins** and **Students** such as borrowing, returning, managing, and reading books. Upgrades include JSON persistence, password-based login, PDF reading support, and a GUI version.

---

## 📁 Project Structure


---

## ✅ Features

### Admin Capabilities
- Add, remove, and search books
- View all books in the library
- Write an e-book (planned)
- View borrowed books and users (planned)
- Add/remove users (planned)
- Export book/user data (planned)

### Student Capabilities
- Borrow and return books
- Search and view books
- Read e-books (planned)
- View currently borrowed books (planned)

### General System Features
- 🔒 Role-based login: Admin / Student
- 🔐 Password-based authentication (in progress)
- 🧠 User session handling
- 📦 JSON-based data persistence using Gson
- 📖 Future support for PDF e-book reading (via Apache PDFBox)
- 🖥️ GUI version (planned using JavaFX)

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven

### Run the Project

```bash
# Compile and run
mvn clean install
java -cp target/classes com.example.Main

