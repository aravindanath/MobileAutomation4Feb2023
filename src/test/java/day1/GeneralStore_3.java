package day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GeneralStore_3 extends  BaseClass{

    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String pageSource = driver.getPageSource();

//        System.out.println("pageSource = " + pageSource);

         int intIndex = pageSource.indexOf("Please enter your name");

         if(intIndex == - 1){
             System.out.println("Please enter not found");


         }else{
             System.out.println("found");
         }


    }
}
