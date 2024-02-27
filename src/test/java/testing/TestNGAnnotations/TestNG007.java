package testing.TestNGAnnotations;

import org.testng.annotations.Test;

public class TestNG007 {

    @Test(priority = 2,groups = {"smoke"})
    public void getToken(){
        System.out.println("i got token ");

    }
    @Test(priority = 1, groups = {"regression"} )
    public void getBookinID(){
        System.out.println("I got id");
    }

    @Test(dependsOnGroups = {"smoke","regression"})
    public void putRequest(){
        System.out.println("I can make put request now");

    }
}
