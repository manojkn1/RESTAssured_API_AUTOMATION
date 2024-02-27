package testing.TestNGAnnotations;

import org.testng.annotations.Test;

public class TestNG005 {

    @Test(groups = {"smoke"})
    public void t1(){
        System.out.println("1");

    }
    @Test(groups = {"smoke","regression"})
    public void t2(){
        System.out.println("2");
    }

    @Test(groups = {"sanity"})
    public void t3(){
        System.out.println("3");

    }
}
