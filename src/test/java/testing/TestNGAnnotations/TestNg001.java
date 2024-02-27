package testing.TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg001 {

    @Test
    public void testCase1(){

        Assert.assertEquals("ture","false");
    }

    @Test
    public void testCase2(){

        Assert.assertEquals("false","false");
    }
}
