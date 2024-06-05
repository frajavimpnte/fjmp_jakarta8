/*
*  ERROR:
*       INFO: WELD-000900: 3.1.1 (Final)
*       Exception in thread "main" java.lang.reflect.InaccessibleObjectException: 
         Unable to make protected final 
*   SOLVE:
*       usar java 1.8: project>properties>build>compile   cambiar a JDK 1.8
*       modifivar pom.xml: cambiar a maven compiler 1.8
*/
package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {   
        super( testName );
        System.out.println("AppTest constructor--------------");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        System.out.println("suite()--------------");
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        System.out.println("testApp()--------------");
        assertTrue( true );
    }
}
