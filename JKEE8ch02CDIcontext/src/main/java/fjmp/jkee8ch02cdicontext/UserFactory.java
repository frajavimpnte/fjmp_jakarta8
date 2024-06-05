package fjmp.jkee8ch02cdicontext;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

// funciona pero no se injecta, esto esto es para REST
//import javax.ws.rs.Produces;

// no funciona!!
import javax.enterprise.inject.Produces;


/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@RequestScoped
public class UserFactory implements Serializable {    
   /*
    public UserFactory() {
    }
    */
    @Produces
    public User getUser() {
        return new User("Francisco", "frajavimopu@gmail.com");
    } 
}
