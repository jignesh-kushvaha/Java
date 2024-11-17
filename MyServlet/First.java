package MyServlet;

import java.io.*;
import javax.servlet.*;

public class First implements Servlet
{

    ServletConfig config=null;  
    public void init(ServletConfig config)
    {
        this.config=config;
        System.out.println("servlet is initialized");  
    }

public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<html><body>");
out.println("<h1>hello this is simple servlet</h1>");
out.println("</body></html>");
}

public void destroy()
{
    System.out.println("servlet is destroyed");
}
public ServletConfig getServletConfig(){return config;}  
public String getServletInfo(){return "copyright 2007-1010";}  
}