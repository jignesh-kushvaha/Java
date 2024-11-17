import java.time.LocalDateTime;
import java.io.*;
import javax.servlet.*;

public class Que1 extends GenericServlet{
    public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        LocalDateTime currentTime = LocalDateTime.now();

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Current Date :</h1");
        out.println("<h3>" + currentTime + "</h3");
        out.println("</body></html>");

        out.close();
    }
}