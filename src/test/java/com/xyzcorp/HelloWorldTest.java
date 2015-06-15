package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Daniel Hinojosa
 * @since 8/10/14 5:48 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class HelloWorldTest {

    @Test
    @Category(UnitTest.class)
    public void simpleUnitTest() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("Logan");
        assertEquals(helloWorld.greet(), "success");
    }

    @Test
    @Category(IntegrationTest.class)
    public void simpleIntegrationTest() throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(true);
    }

    @Test
    @Category(AcceptanceTest.class)
    public void simpleAcceptanceTest() throws InterruptedException {
        Thread.sleep(10000);
        assertTrue(true);
    }
}
