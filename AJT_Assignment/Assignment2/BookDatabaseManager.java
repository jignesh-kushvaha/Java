package AJT_Assignment.Assignment2;

import java.sql.*;
import java.util.Scanner;

public class BookDatabaseManager {
    private static Connection con = DatabaseConnection.connect();

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== Book Database Management ==========");
            System.out.println("1. Insert a New Book");
            System.out.println("2. Update Book Price");
            System.out.println("3. Delete a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.next();
                    System.out.print("Enter Book Author: ");
                    String author = sc.next();
                    System.out.print("Enter Book Publisher: ");
                    String publisher = sc.next();
                    System.out.print("Enter Book Price: ");
                    double price = sc.nextDouble();

                    InsertBook(title, author, publisher, price);
                    break;

                case 2:
                    System.out.print("Enter Book ID to Update: ");
                    int idToUpdate = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    UpdateBook(idToUpdate, newPrice);
                    break;

                case 3:
                    System.out.print("Enter Book ID to Delete: ");
                    int idToDelete = sc.nextInt();
                    DeleteBook(idToDelete);
                    break;

                case 4:
                    DisplayBook();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();


//            InsertBook("Java: The Complete Reference","Herbert Schildt","McGraw-Hill Education",3999);
//            InsertBook("The C Programming Language","Brian W. Kernighan, Dennis M. Ritchie","Prentice Hall",2999);
//            DeleteBook(4);
//            DisplayBook();
//            UpdateBook(2,1500);
//            DisplayBook();

//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    public static void InsertBook(String title, String author,String publisher,double price) throws Exception{
        String query = "INSERT INTO Book (title, author, publisher, price) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedstatement = con.prepareStatement(query);
        preparedstatement.setString(1, title);
        preparedstatement.setString(2, author);
        preparedstatement.setString(3, publisher);
        preparedstatement.setDouble(4, price);
        preparedstatement.executeUpdate();
        System.out.println("Book inserted successfully.");
    }

    public static void DisplayBook() throws Exception{
        String query = "select * from Book";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String publisher = rs.getString("publisher");
            double price = rs.getDouble("price");

            System.out.println(new Book(id,title,author,publisher,price));
        }
    }
    public static void UpdateBook(int id, double price) {
        String updateQuery = "UPDATE Book SET price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void DeleteBook(int id) throws Exception{
        String query = "delete from Book where id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,id);
        pst.executeUpdate();
        System.out.println("Book Deleted...");
    }
}
