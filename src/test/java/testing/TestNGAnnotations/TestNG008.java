package testing.TestNGAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG008 {

    @Parameters("browser")
@Test
public void test1(String value){
    System.out.println("browser is"+value);
}
}
