package AJT_Assignment.Assignment4.Question2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class BookServiceImpl extends UnicastRemoteObject implements BookService{
    public BookServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getBookDetail(int id) throws Exception{
        Connection con = DatabaseConnection.connect();

        String query = "SELECT * FROM book WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
          String title = rs.getString("title");
          String author = rs.getString("author");
          Double price = rs.getDouble("price");

          return "Book: " + title + " - Author: " + author + " - Price: ₹" + price;
        }else {
            return "No Book Found!";
        }
    }
}
