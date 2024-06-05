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

/**
 *
 * @author xeon
 */
public class JKEE8ch01BeanValidation {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
