package fjmp.jkee8ch03restjaxrscdi;

import java.io.Serializable;
import java.net.URI;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@ViewScoped
@Named
public class UserView implements Serializable {
    public void loadUsers() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(
                URI.create("http://localhost:8080/JKEE8ch03RestJaxRSCDI/"));
        
        User response = target.path("webresources/userservice/getUserFromBean")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(User.class);
        
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("userFromBean: " + response));
        
        response = target.path("webresources/userservice/getUserFromLocal")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(User.class);
        
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("userFromLocal: " + response));
        
        client.close();
    }
}
