package fjmp.jkee8ch02serverpush;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@WebFilter(filterName = "PushFilter", urlPatterns = {"/*"})
public class PushFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, 
    ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpReq = (HttpServletRequest)request;
        PushBuilder builder = httpReq.newPushBuilder();
        
        if (builder != null){
            builder
                .path("resources/javaee-logo.png")
                .path("resources/style.css")
                .path("resources/functions.js")
                .push(); 
            System.out.println("Resources pushed");
        }

        chain.doFilter(request, response);
        
    }   
}