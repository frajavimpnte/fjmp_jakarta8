package fjmp.jkee8ch05auth;

import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@DeclareRoles({"role1", "role2", "role3"})
@WebServlet(name="/UserAuthenticationServlet", urlPatterns = {"/UserAuthenticationServlet"})
public class UserAuthenticationServlet extends HttpServlet{
   private static final long serialVersoinUID = 1L;
   
   @Inject
   private javax.security.enterprise.SecurityContext securityContext;
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
   
       String name = request.getParameter("name");
       if (null != name || !"".equals(name)) {
           AuthenticationStatus status = securityContext.authenticate(request, response, 
                   AuthenticationParameters.withParams().credential( 
                   new CallerOnlyCredential(name)));
           
           response.getWriter().write("Authentication status: " 
                   + status.name() + "\n");
       }
       
       String principal = null;
       if (request.getUserPrincipal() != null) {
           principal = request.getUserPrincipal().getName();
       }
       
       response.getWriter().write("User: " + principal + "\n");
       response.getWriter().write("Role: \"role1\" access: " + 
               request.isUserInRole("role1") + "\n");
       response.getWriter().write("Role: \"role2\" access: " + 
               request.isUserInRole("role2") + "\n");
       response.getWriter().write("Role: \"role3\" access: " + 
               request.isUserInRole("role3") + "\n");
   }
}
