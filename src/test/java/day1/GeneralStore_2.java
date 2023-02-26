package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GeneralStore_2 extends  BaseClass{

    @Test
    public void test() throws InterruptedException {
       driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        Thread.sleep(3000);
        String country = "Haiti";
        Generics.scrollToElementAndClick(driver, country);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String value =  driver.findElement(By.xpath("//android.widget.Toast[@text='Please enter your name']")).getText();
        System.out.println("Toast Msg: " + value);
    }
}
