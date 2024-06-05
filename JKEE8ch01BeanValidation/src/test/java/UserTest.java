/*
* Libro: Jakarta EE 8 Cookbook
* Folder: Devel_JakartaEE8_book
* ESTE SI COMIPILA PERO NO USA CDI!!!!!
* EL CDI ESTA EN TEST PACKAGES SI FUNCIONA!!!!
*
*ERROR:
*       INFO: WELD-000900: 3.1.1 (Final)
*       Exception in thread "main" java.lang.reflect.InaccessibleObjectException: Unable to make protected final 
*   SOLVE:
*       usar java 1.8: project>properties>build>compile   cambiar a JDK 1.8
*       modifivar pom.xml: cambiar a maven compiler 1.8
*/
import com.example.User;

import static java.util.Arrays.asList;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
 
    private static Validator validator;
 
    @BeforeClass
    public static void setUpClass() {
        validator = Validation.buildDefaultValidatorFactory()
        .getValidator();
    }
 
    @Test
    public void validUser() {
        User user = new User(
            "elder", 
            "elder@eldermoraes.com", 
            asList(1,2));
 
            Set<ConstraintViolation<User>> cv = validator
            .validate(user);
            System.out.println("validUser: " + cv.size());
            assertTrue(cv.isEmpty());
    }
 
    @Test
    public void invalidName() {
        User user = new User(
            "", 
            "elder@eldermoraes.com", 
            asList(1,2));
 
            Set<ConstraintViolation<User>> cv = validator
            .validate(user);
            System.out.println("invalidName: " + cv.size());
            assertEquals(1, cv.size());
    }

    @Test
    public void invalidEmail() {
        User user = new User(
        "elder",

        "elder-eldermoraes_com", 
        asList(1,2));
 
        Set<ConstraintViolation<User>> cv = validator
        .validate(user);
        System.out.println("invalidEmail: " + cv.size());
        assertEquals(1, cv.size());
    } 
 
    @Test
    public void invalidId() {
        User user = new User(
            "elder", 
            "elder@eldermoraes.com", 
            asList(-1,-2,1,2));
 
            Set<ConstraintViolation<User>> cv = validator
            .validate(user);
            System.out.println("invalidId: " + cv.size());
            assertEquals(2, cv.size());
    } 
}