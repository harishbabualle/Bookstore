package com.example.bookstore.models;

public class Store {
    String BookId;
    String BookName;
    String BookQuantity;

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookQuantity() {
        return BookQuantity;
    }

    public void setBookQuantity(String bookQuantity) {
        BookQuantity = bookQuantity;
    }

    public Store(String bookId, String bookName, String bookQuantity) {
        BookId = bookId;
        BookName = bookName;
        BookQuantity = bookQuantity;
    }
}

