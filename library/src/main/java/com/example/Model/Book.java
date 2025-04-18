package com.example.Model;

public class Book {
    private String bookName;
    private String authorName;
    private String bookId;
    private Boolean existingHolder;
    private String holderId;

    public Book(String bookName, String authorName, String bookId, Boolean existingHolder, String holderId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookId = bookId;
        this.existingHolder = existingHolder;
        this.holderId = holderId;
    }

    public String getbookName() {
        return bookName;
    }

    public String getauthorName() {
        return authorName;
    }

    public String getbookId() {
        return bookId;
    }

    public Boolean getexistingHolder() {
        return existingHolder;
    }

    public String getholderId() {
        return holderId;
    }

    public void setbookName(String bookName) {
        this.bookName = bookName;
    }

    public void setauthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setbookId(String bookId) {
        this.bookId = bookId;
    }

    public void setexistingHolder(Boolean existingHolder) {
        this.existingHolder = existingHolder;
    }

    public void setholderId(String holderId) {
        this.holderId = holderId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookId='" + bookId + '\'' +
                ", existingHolder=" + existingHolder +
                ", holderId='" + holderId + '\'' +
                '}';
    }

}
