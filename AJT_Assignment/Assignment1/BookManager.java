package AJT_Assignment.Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private static final String FILE_PATH = "AJT_Assignment/Assignment1/Books.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = loadBooks();

        while (true) {
            System.out.println("\n--- Book Manager ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Query Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook(sc, books);
                    saveBooks(books);
                    break;
                case 2:
                    displayBooks(books);
                    break;
                case 3:
                    queryBook(sc, books);
                    break;
                case 4:
                    updateBook(sc, books);
                    saveBooks(books);
                    break;
                case 5:
                    deleteBook(sc, books);
                    saveBooks(books);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static List<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private static void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    private static void addBook(Scanner sc, List<Book> books) {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Book Name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String authorName = sc.nextLine();
        System.out.print("Enter Publication: ");
        String publication = sc.nextLine();
        System.out.print("Enter Price :");
        Double price = sc.nextDouble();

        books.add(new Book(bookId, bookName, authorName, publication, price));
        System.out.println("Book added successfully!");
    }

    private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- List of Books ---");
        System.out.printf("%-10s %-40s %-20s %-25s %-15s\n", "Book ID", "Book Name", "Author Name", "Publication", "Price");
        System.out.println("---------------------------------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void queryBook(Scanner sc, List<Book> books) {
        System.out.println("Query by:");
        System.out.println("1. Book ID");
        System.out.println("2. Book Name");
        System.out.println("3. Author Name");
        System.out.println("4. Publication");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        switch (choice) {
            case 1:
                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                for (Book book : books) {
                    if (book.getBookId() == bookId){
                        System.out.printf("%-10s %-40s %-20s %-25s %-15s\n", "Book ID", "Book Name", "Author Name", "Publication", "Price");
                        System.out.println(book);
                        found = true;
                    }
                }
                break;
            case 2:
                System.out.print("Enter Book Name: ");
                String bookName = sc.nextLine();
                for (Book book : books) {
                    if (book.getBookName().equalsIgnoreCase(bookName)){
                        System.out.printf("%-10s %-40s %-20s %-25s %-15s\n", "Book ID", "Book Name", "Author Name", "Publication", "Price");
                        System.out.println(book);
                        found = true;
                    }
                }
                break;
            case 3:
                System.out.print("Enter Author Name: ");
                String authorName = sc.nextLine();
                for (Book book : books) {
                    if (book.getAuthorName().equalsIgnoreCase(authorName)){
                        System.out.printf("%-10s %-40s %-20s %-25s %-15s\n", "Book ID", "Book Name", "Author Name", "Publication", "Price");
                        System.out.println(book);
                        found = true;
                    }
                }
            case 4:
                System.out.print("Enter Publication: ");
                String publication = sc.nextLine();
                for (Book book : books) {
                    if (book.getPublication().equalsIgnoreCase(publication)){
                        System.out.printf("%-10s %-40s %-20s %-25s %-15s\n", "Book ID", "Book Name", "Author Name", "Publication", "Price");
                        System.out.println(book);
                        found = true;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }

        if(!found){
            System.out.println("Book Not Found");
        }
    }

    private static void updateBook(Scanner sc, List<Book> books) {
        System.out.print("Enter Book ID to update: ");
        int bookId = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                System.out.print("Enter new Book Name (leave blank to keep current): ");
                String bookName = sc.nextLine();
                if (!bookName.isEmpty()) book.setBookName(bookName);

                System.out.print("Enter new Author Name (leave blank to keep current): ");
                String authorName = sc.nextLine();
                if (!authorName.isEmpty()) book.setAuthorName(authorName);

                System.out.print("Enter new Publication (leave blank to keep current): ");
                String publication = sc.nextLine();
                if (!publication.isEmpty()) book.setPublication(publication);

                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    private static void deleteBook(Scanner sc, List<Book> books) {
        System.out.print("Enter Book ID to delete: ");
        int bookId = sc.nextInt();

        books.removeIf(book -> book.getBookId() == bookId);
        System.out.println("Book deleted successfully!");
    }
}


