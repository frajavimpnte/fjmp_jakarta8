package fjmp.jkee8ch02ejbconcurrency;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class UserSelfManagedBean {

    private int userCount;

    public int getUserCount() {
        return userCount;
    }
    
    public synchronized void addUser(){
        userCount++;
    }
}