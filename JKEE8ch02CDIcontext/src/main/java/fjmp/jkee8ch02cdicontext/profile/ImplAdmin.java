package fjmp.jkee8ch02cdicontext.profile;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile{
    @Override
    public ProfileType type() {
        System.out.println("User is admin.");
        return ProfileType.ADMIN;
    }
}
