package fjmp.jkee8ch02ejbconcurrency;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 10000)
public class UserMethodLevelBean {

    private int userCount;
    
    @Lock(LockType.READ)
    public int getUserCount(){
        return userCount;
    }
    
    @Lock(LockType.WRITE)
    public void addUser(){
        userCount++;
    }
}