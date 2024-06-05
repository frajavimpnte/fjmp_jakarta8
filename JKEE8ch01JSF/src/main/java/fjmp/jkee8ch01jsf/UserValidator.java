package fjmp.jkee8ch01jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
@FacesValidator("userValidator")
public class UserValidator implements Validator<User>{
    @Override
    public void validate(FacesContext fc, UIComponent uic, User user) throws ValidatorException  {
        if (!user.getEmail().contains("@")  || "".equals(user.getName())) {
            throw new ValidatorException(
                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                          "Malformed e-mail", null));
        }
    }
}
