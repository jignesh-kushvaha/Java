import java.sql.*;
public class BookDatabaseManager {
    private static Connection con = DatabaseConnection.connect();

    public static void main(String[] args) {
        try{
//            InsertBook("Java: The Complete Reference","Herbert Schildt","McGraw-Hill Education",3999);
//            InsertBook("The C Programming Language","Brian W. Kernighan, Dennis M. Ritchie","Prentice Hall",2999);
            DeleteBook(4);
            DisplayBook();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void InsertBook(String title, String author,String publisher,double price) throws Exception{
        String query = "INSERT INTO Book (title, author, publisher, price) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, publisher);
        statement.setDouble(4, price);
        statement.executeUpdate();
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

    public static void DeleteBook(int id) throws Exception{
        String query = "delete from Book where id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,id);
        pst.executeUpdate();
        System.out.println("Book Deleted...");
    }
}
