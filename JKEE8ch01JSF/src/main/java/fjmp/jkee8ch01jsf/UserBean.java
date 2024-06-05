package fjmp.jkee8ch01jsf;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Named(value = "userBean")
@RequestScoped
public class UserBean implements Serializable {
    private User user;
    
    @PostConstruct
    public void init(){
        user = new User("Francisco FJMP", "frajavimopu@gmail.com");
    }
    public UserBean() {    
    }
    
    public void userAction() {
        System.out.println("userAction----------------------");
        
        // FUNCIONA DE FORMA GLOBAL!!!!!!!!!!!
        //FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
        //   "Name|Password welformed!", null);
        //FacesContext.getCurrentInstance().addMessage(null, javaTextMsg);

        
        FacesContext.getCurrentInstance().addMessage("componentForm:userNameEmail", 
                new FacesMessage("Name|Password welformed"));
        
         //FacesContext.getCurrentInstance().addMessage(null, 
          //      new FacesMessage("Name|Password welformed"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
