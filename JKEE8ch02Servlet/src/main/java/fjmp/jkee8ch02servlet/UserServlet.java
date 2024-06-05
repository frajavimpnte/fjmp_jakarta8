package fjmp.jkee8ch02servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet{
    private User user;
    
    @PostConstruct
    public void instantiateUser() {
        user = new User("Francisco J.", "frajavimopu@gmail.com");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }
    
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has destroyed");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }
    
    protected void doRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet UserServlet at " + 
                         request.getContextPath() + "</h2>");
            out.println("<h2>Now: " + new Date() + "</h2>");
            out.println("<h2>User: " + user.getName() + "/" + 
                        user.getEmail() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
