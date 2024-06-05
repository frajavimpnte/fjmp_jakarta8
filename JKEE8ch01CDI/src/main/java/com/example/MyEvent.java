/*
*   Folder: Devel_jakartaEE8_book

*   SI FUNCIONA 
*   HABI ERROES 
*   ERROR:
*       INFO: WELD-000900: 3.1.1 (Final)
*       Exception in thread "main" java.lang.reflect.InaccessibleObjectException: Unable to make protected final 
*   SOLVE:
*       usar java 1.8: project>properties>build>compile   cambiar a JDK 1.8
*       modifivar pom.xml: cambiar a maven compiler 1.8
*/

package com.example;

 class MyEvent {
    
    private final String value;
    
    public MyEvent(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
}