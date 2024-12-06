package AJT_Assignment.Assignment1;

import java.io.*;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private int bookId;
    private String bookName;
    private String authorName;
    private String publication;

    private Double price;

    public Book(int bookId, String bookName, String authorName, String publication, Double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publication = publication;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublication() {
        return publication;
    }

    public Double getPrice(){
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-40s %-20s %-25s %-15s", bookId, bookName, authorName, publication,price);
    }
}
