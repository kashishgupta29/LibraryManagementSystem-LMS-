package com.example.Service;

// import java.awt.print.Book;

import java.util.List;

import com.example.Model.Book;

public class libManagementSys {
    private List<Book> books;

    public void borrowBook(Book book, String userId) {
        if (book != null && !book.getexistingHolder()) {
            book.setholderId(userId);
            book.setexistingHolder(true);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Cannot borrow. Book is either null or already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (book != null && book.getexistingHolder()) {
            book.setholderId(null);
            book.setexistingHolder(false);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Cannot return. Book is either null or not borrowed.");
        }
    }

}
