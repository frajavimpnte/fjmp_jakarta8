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
package com.example;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;


public class User {

    @NotBlank
    private String name;
    
    @Email
    private String email;
    
    @NotEmpty
    private List<@PositiveOrZero Integer> profileId;
    
    
    public User(String name, String email, List<Integer> profileId) {
        this.name = name;
        this.email = email;
        this.profileId = profileId;
    }
}