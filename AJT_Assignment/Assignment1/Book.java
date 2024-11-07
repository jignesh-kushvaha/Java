package AJT_Assignment.Assignment1;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int lastBookId = 0;
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private Double price;

    public Book(String title,String author,String publisher,Double price){
        this.bookId = ++lastBookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return bookId + "," + title + "," + author + "," + publisher + ",₹" + price;
    }

}
