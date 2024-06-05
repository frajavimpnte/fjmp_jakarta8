package fjmp.jkee8ch02beanvalidation;

import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class User {
    @NotBlank (message = "Name should not be blank")
    @Size (min = 4, max = 10, message = "Name should be between 4 and 10 characters")
    private String name;
    
    @Email (message = "Invalid e-mail format")
    @NotBlank (message = "Name should not be blank")
    private String email;
    
    @PastOrPresent (message = "Created data should be past or present")
    @NotNull (message = "Name should not be null")
    private LocalDate created;
    
    @Future (message = "Expires should be a future data")
    @NotNull (message = "Name should not be null")
    private LocalDate expires;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }
    
    public void valid(){
        FacesContext
                .getCurrentInstance()
                .addMessage(
                    null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Your data is valid", ""));
    }
}