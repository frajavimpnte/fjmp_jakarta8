package fjmp.jkee8ch03restjaxrscdi;

import java.io.Serializable;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
public class User implements Serializable {
    private String name;
    private String email;
    
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

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
    
    
}
