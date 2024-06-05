package fjmp.jkee8ch01mvc;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Path("userController")
public class UserController {
    
    @Inject
    private Models models;
    
    @Inject
    private UserBean userBean;
    
    @GET
    @Controller
    public String user(){
        models.put("user", userBean.getUser());
        return "/user.jsp";
    }
}
