package com.example.Database;

import java.util.ArrayList;
import java.util.List;

import com.example.Model.Admin;//trees//
import com.example.Model.Book;
import com.example.Model.Student;

public class libraryDatabase {
    private List<Object> users;
    private List<Book> books;

    public void loginUser() {

    }

    public libraryDatabase() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addUser(Object User) {
        if (User instanceof Admin)
            users.add(User);
        else if (User instanceof Student)
            users.add(User);
        System.out.println("User is Added");
    }

    public void removeUser(Object User) {
        if (users.remove(User))
            System.out.println("The user is removed");
        else
            System.out.println("User not found");
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        if (books.remove(book))
            System.out.println("Book is removed");
        else
            System.out.println("Book not found");
    }

    public Boolean searchUser(Object User) {
        return users.contains(User);
    }

    public Boolean searchBook(Book book) {
        return books.contains(book);
    }

    public Book getBook(String bookId) {
        for (Book book : books) {
            if (book.getbookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getAllBooks() {
        return (ArrayList<Book>) books;
    }

    public Object getBooks() {
        return books;
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    public void readBooks()
    {

    }


}
