package fjmp.jkee08ch05autoriza;

import javax.annotation.security.RunAs;
import javax.inject.Named;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Named
@RunAs(Roles.ROLE3)
public class Role3Executor implements RoleExecutable {
    @Override
    public void run(Executable executable) throws Exception {
        executable.execute();
    }
}
