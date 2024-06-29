package fjmp.jkee8ch04servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@WebServlet(name = "LoadOnStartupServlet", urlPatterns={"/LoadOnStartupServlet"},
        loadOnStartup = 1)
public class LoadOnStartupServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("******************SERVLET LOADED"
                + "WHIH SERVER'S STARTUP*********************");
    }
}
