package com.example.Configuration;

import java.util.Scanner;

import com.example.Database.libraryDatabase;
import com.example.Model.Admin;
import com.example.Model.Book;
import com.example.Model.Student;
import com.example.Service.libManagementSys;

public class Session {

    private final libraryDatabase database;
    private final libManagementSys managementSys;
    private Boolean activeSession;

    public Session(libraryDatabase database, Boolean activeSession) {
        this.database = database;
        this.activeSession = activeSession;
        this.managementSys = new libManagementSys();
    }

    public void start() {
        Scanner s = new Scanner(System.in);

        while (activeSession) {
            System.out.println("LOGIN INTO LIBRARY SYSTEM");
            System.out.print("Enter your username: ");
            String name = s.nextLine();
            name = name.toLowerCase();

            System.out.print("Enter your userId: ");
            String userId = s.nextLine();
            userId = userId.toLowerCase();

            System.out.print("Enter your role (Admin/Student) or 'exit or quit' to exit: ");
            String role = s.nextLine().toLowerCase();

            if (role.equals("quit") || role.equals("exit")) {
                System.out.println("Exiting the system😊");
                activeSession = false;
                s.close();
                break;
            }

            switch (role) {
                case "admin" -> {
                    Admin admin = new Admin(userId, name);
                    database.addUser(admin);
                    descisionAdmin();
                    // break;
                }

                case "student" -> {
                    Student student = new Student(userId, name);
                    database.addUser(student);
                    descisionStudent(student);
                    // break;
                }

                default -> {
                    System.out.println("Invalid Role...Try again later");
                }
            }
        }
        // s.close();
    }

    public void descisionAdmin() {
        Scanner s = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("Admin Menu");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search a Book");
            System.out.println("4. View All available Books");
            System.out.println("5. Write a E-BOOK");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = s.hasNextInt() ? s.nextInt() : -1;
            s.nextLine();

            switch (choice) {
                case 1 -> {
                    {
                        System.out.println("Enter book name: ");
                        String bookName = s.nextLine();

                        System.out.println("Enter author name: ");
                        String authorName = s.nextLine();

                        System.out.println("Enter book id: ");
                        String bookId = s.nextLine();

                        Book book = new Book(bookName, authorName, bookId, false, null);
                        database.addBook(book);
                        // break;
                    }
                }
                case 2 -> {
                    {
                        System.out.println("Enter the bookId of the book to be removed: ");
                        String bookId = s.nextLine();
                        Book book = database.getBook(bookId);
                        if (book != null) {
                            database.removeBook(book);
                        } else {
                            System.out.println("Book not found:)");
                        }
                        // break;
                    }
                }
                case 3 -> {
                    {
                        System.out.println("Enter the bookId of book to search: ");
                        String bookId = s.nextLine();
                        Book foundBook = database.getBook(bookId);
                        if (foundBook != null) {
                            System.out.println("Book found: " + foundBook);
                        } else {
                            System.out.println("Book not found:)");
                        }
                        // break;
                    }
                }
                case 4 -> {
                    {
                        System.out.println("All the books  available in the library:");
                        for (Book b : database.getAllBooks()) {
                            System.out.println(b);
                        }
                        // break;
                    }
                }
                case 5 -> {

                }
                case 6 -> {
                    {
                        System.out.println("Logging out...");
                        loggedIn = false;
                        s.close();
                        // break;
                    }
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    public void descisionStudent(Student student) {
        Scanner s = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("Student Menu");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Search a Book");
            System.out.println("4. View All Books");
            System.out.println("5. Read an E-Book");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = s.hasNextInt() ? s.nextInt() : -1;
            s.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter the bookId to borrow: ");
                    String bookId = s.nextLine();
                    Book book = database.getBook(bookId);
                    if (book != null) {
                        managementSys.borrowBook(book, student.getuserId());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter the bookId to return: ");
                    String bookId = s.nextLine();
                    Book book = database.getBook(bookId);
                    if (book != null) {
                        managementSys.returnBook(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the bookId to search: ");
                    String bookId = s.nextLine();
                    Book foundBook = database.getBook(bookId);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("All books in the library:");
                    for (Book b : database.getAllBooks()) {
                        System.out.println(b);
                    }
                    break;
                }
                case 5: {
                    // PDDocument document = PDDocument.load(new File("test.pdf"));
                    // if (!document.isEncrypted()) {
                    // PDFTextStripper stripper = new PDFTextStripper();
                    // String text = stripper.getText(document);
                    // System.out.println("Text:" + text);
                    // }

                }
                case 6: {
                    System.out.println("Logging out...");
                    loggedIn = false;
                    s.close();
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

}
