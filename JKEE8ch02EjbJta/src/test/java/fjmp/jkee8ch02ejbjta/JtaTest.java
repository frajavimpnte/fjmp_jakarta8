package fjmp.jkee8ch02ejbjta;

import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
public class JtaTest {
    private EJBContainer ejbContainer;
    
    @EJB
    private UserBean userBean;
    
    public JtaTest() {
    }
    
    @Before
    public void setUp() throws NamingException {
        Properties p = new Properties();
        p.put("userDb", "new://Resource?type=DataSource");
        p.put("userDb.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("userDb.JdbcUrl", "jdbc:hsqldb:mem:userdatabase");

        ejbContainer = EJBContainer.createEJBContainer(p);
        ejbContainer.getContext().bind("inject", this);
    }
    
    @After
    public void tearDown() {
        ejbContainer.close();
    }
    
    @Test
    public void validTransaction() throws Exception{
        User user = new User(null, "Francisco Javier", 
                             "frajavimopu@gmail.com");
        System.out.println("validTransaction()---------------------------");
        userBean.add(user);
        user.setName("John Doe");
        userBean.update(user);
        
        User userDb = userBean.findById(1L);
        assertEquals(userDb.getName(), "John Doe");
        
    }
}
