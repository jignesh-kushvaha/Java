package AJT_Assignment.Assignment2;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book(int id, String title, String author,String publisher, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", publisher: "+ publisher +", Price: " + price;
    }
}
