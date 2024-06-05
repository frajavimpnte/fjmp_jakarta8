package fjmp.jkee8ch01mvc;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Stateless
@Named
public class UserBean {
    public UserBean() {}
    public User getUser(){
        return new User("Francisco", "francisco@frajavimopu.com");
    }
}