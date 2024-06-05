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


import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptor;



public class OrderedObserver {

    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        
        // Launch event, and it is observed following order.
        container.getBeanManager().fireEvent(new MyEvent("event -> " + System.currentTimeMillis()));
    }

    // method called before event
    public void thisEventBefore(@Observes @Priority(Interceptor.Priority.APPLICATION - 200) MyEvent event) {
        System.out.println("thisEventBefore: " + event.getValue());
    }

    // method called after event
    public void thisEventAfter(@Observes @Priority(Interceptor.Priority.APPLICATION + 200) MyEvent event) {
        System.out.println("thisEventAfter: " + event.getValue());
    }

}