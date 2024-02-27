package testing.TestNGAnnotations;

import org.testng.annotations.*;

public class TestNG002 {
 // Sequence of important TestNg Annotations
    @BeforeSuite
    public void testCase7(){
        System.out.println("Before suite");

    }

    @BeforeTest
    public void testCase5(){
        System.out.println("Before Test");

    }
    @BeforeClass
    public void testCase9(){
        System.out.println("Before Class");

    }

    @BeforeMethod
    public void testCase3(){
        System.out.println("Before method");

    }

    @Test
    public void testCase1(){
        System.out.println("Test 1");

    }
    @Test
    public void testCase2(){
        System.out.println("Test 2");

    }

   @AfterMethod
    public void testCase4(){
        System.out.println("After method");

    }


    @AfterClass
    public void testCase10(){
        System.out.println("After class");

    }

    @AfterTest
    public void testCase6(){
        System.out.println("After Test");

    }


    @AfterSuite
    public void testCase8(){
        System.out.println("After Suite");

    }
}
