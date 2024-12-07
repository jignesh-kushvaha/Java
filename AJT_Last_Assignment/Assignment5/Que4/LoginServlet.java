import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if ("admin".equals(username) && "123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie passwordCookie = new Cookie("password",password);
            passwordCookie.setMaxAge(60 * 60);  
            response.addCookie(passwordCookie);

            response.sendRedirect("DashboardServlet");
        } else {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid username or password!</h3>");
            out.println("<h3>"+ username + "</h3>");
            out.println("<h3>"+ password + "</h3>");
            out.println("<a href=\"index.html\">Try Again</a>");
        }
    }
}
