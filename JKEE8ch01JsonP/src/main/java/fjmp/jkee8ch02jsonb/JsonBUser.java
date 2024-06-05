package fjmp.jkee8ch02jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
public class JsonBUser {
     public static void main(String[] args) throws Exception {
        User user = new User("Elder", "elder@eldermoraes.com");
        
        Jsonb jb = JsonbBuilder.create();
        String jsonUser = jb.toJson(user);
        User u = jb.fromJson(jsonUser, User.class);
        
        jb.close();
        System.out.println("json: " + jsonUser);
        System.out.println("user: " + u);
        
    }
}
