package fjmp.jkee8ch03restjaxrscdi;

import javax.ejb.Stateless;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Stateless
public class UserBean {
    public User getUser() {
        long ts = System.currentTimeMillis();
        return new User("Bean" + ts, "user" + ts + "@fjmp.com");
    }
}
