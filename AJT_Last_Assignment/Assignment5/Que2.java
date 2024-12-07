import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Que2 extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/demo";
    private static final String USER = "root";
    private static final String PASSWORD = "Jignesh@1410";

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        String BookId = req.getParameter("bookid");

        if(BookId == null || BookId.isEmpty()){
            res.getWriter().println("<h1> Enter Book Id</h1>");
            return;
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            String query = "select * from book where id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(BookId));

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                res.getWriter().println("<h2>Book Details</h2>");
                res.getWriter().println("<p><b>Title:</b> " + rs.getString("title") + "</p>");
                res.getWriter().println("<p><b>Author:</b> " + rs.getString("author") + "</p>");
                res.getWriter().println("<p><b>Price:</b> " + rs.getString("price") + "</p>");
            }else{
                res.getWriter().println("<h2>No book found with this ID!!</h2>");
            }

        }catch (Exception ex){
            ex.printStackTrace();
            res.getWriter().println("<h2>Error fetching book details: " + ex + "</h2>");
        }

    }
}
