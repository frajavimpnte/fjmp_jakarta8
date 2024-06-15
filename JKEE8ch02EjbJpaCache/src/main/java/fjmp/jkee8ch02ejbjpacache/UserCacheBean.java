package fjmp.jkee8ch02ejbjpacache;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Singleton
@Startup
public class UserCacheBean {

    protected Queue<User> cache = null;
    
    @PersistenceContext
    private EntityManager em;

    public UserCacheBean() {
    }

    protected void loadCache() {
        List<User> list = em.createQuery("SELECT u FROM USER as u").getResultList();

        list.forEach((user) -> {
            cache.add(user);
        });
    }

    @Lock(LockType.READ)
    public List<User> get() {
        return cache.stream().collect(Collectors.toList());
    }

    @PostConstruct
    protected void init() {
        cache = new ConcurrentLinkedQueue<>();
        loadCache();
    }
}