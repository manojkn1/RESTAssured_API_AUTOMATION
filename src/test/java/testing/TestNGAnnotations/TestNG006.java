package testing.TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG006 {
    @Test
    public void testCase1(){
        // Soft assertions
        /*SoftAssert s= new SoftAssert();
        s.assertEquals("true","false","actual is true expected is false");
        System.out.println("Execute me");
        s.assertAll();

         */

        // Hard asserion
        Assert.assertEquals("true","false");
        System.out.println("print message");
    }


}
