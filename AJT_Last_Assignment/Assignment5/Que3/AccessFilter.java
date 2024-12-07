import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String bookId = httpRequest.getParameter("bookid");

        if (((bookId != null && !bookId.trim().isEmpty()))) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("invalidInput.html");
        }
    }

    @Override
    public void destroy() {}
}
