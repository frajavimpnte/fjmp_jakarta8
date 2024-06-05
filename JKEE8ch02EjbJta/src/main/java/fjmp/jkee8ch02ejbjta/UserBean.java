package fjmp.jkee8ch02ejbjta;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Stateful
public class UserBean {
    @PersistenceContext(unitName = "jta-pu", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    public void add(User user) {
        em.persist(user);
    }
    
    public void update(User user) {
        em.merge(user);
    }
    
    public void remove(User user) {
        em.remove(user);
    }
    
    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
