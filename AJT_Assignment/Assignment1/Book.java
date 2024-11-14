package AJT_Assignment.Assignment1;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private Double price;

    public Book(int bookId,String title,String author,String publisher,Double price){
        this.bookId = bookId;
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
