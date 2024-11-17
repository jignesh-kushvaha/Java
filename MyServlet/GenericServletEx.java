package MyServlet;

import java.io.*;
import javax.servlet.*;

public class GenericServletEx extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h1>Hello, this is a simple GenericServlet</h1>");
        out.print("</body></html>");
        
    }
    
}
