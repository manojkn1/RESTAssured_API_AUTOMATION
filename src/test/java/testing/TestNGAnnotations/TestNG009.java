package testing.TestNGAnnotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG009 {

@DataProvider
  public Object[][] getData(){

      return new Object[][]{
              new Object[]{"admin","password123"},
              new Object[]{"admin","password1234"},
              new Object[]{"admin","password12345"}

      };
  }


@Test(dataProvider = "getData")
    public void loginTest(String username, String password) {
        System.out.println(username);
        System.out.println(password);

    }
}
