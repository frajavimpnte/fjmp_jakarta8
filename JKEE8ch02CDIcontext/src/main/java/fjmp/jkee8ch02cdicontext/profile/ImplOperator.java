package fjmp.jkee8ch02cdicontext.profile;

import javax.enterprise.inject.Default;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Profile(ProfileType.OPERATOR)
@Default
public class ImplOperator implements UserProfile{
    @Override
    public ProfileType type() {
        System.out.println("User is operator.");
        return ProfileType.OPERATOR;
    }
}
