package fjmp.jkee8ch02jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Stateless
public class UserBean {
    @PersistenceContext (unitName ="jpa-pu", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    public void add(User user) {
        em.persist(user);
    }
    
    public void update(User user){
        em.merge(user);
    }
    
    public void remove(User user){
        em.remove(user);
    }
    
    public User findById(Long id){
        return em.find(User.class, id);
    }       
}
