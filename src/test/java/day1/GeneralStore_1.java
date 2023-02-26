package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GeneralStore_1 extends  BaseClass{

    @Test
    public void test() throws InterruptedException {
       driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
       Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Antarctica']")).click();
        Thread.sleep(3000);
        WebElement textfield=  driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        textfield   .sendKeys("Arvind");
        Thread.sleep(3000);
        textfield.clear();
        textfield.sendKeys("aadvik");

    }
}
