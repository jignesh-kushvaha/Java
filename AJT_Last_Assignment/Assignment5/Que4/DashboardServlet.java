import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        Cookie[] cookies = request.getCookies();
        String password = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Welcome to the Dashboard</h1>");
        out.println("<p>From Session: </p>");
        out.println("<p>Hello, " + session.getAttribute("username") + "!</p>");
        out.println("<p>From cookie: </p>");
        out.println("<p>Hello, " + password + "!</p>");
        out.println("<a href='LogoutServlet'>Logout</a>");
    }
}
