
package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneralStore_5_longpress extends  BaseClass{

    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
        Thread.sleep(2000);
//        ((AndroidDriver)driver).getKeyboard();

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.R));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        List<WebElement> products = driver.findElements(By.xpath
                ("//*[@text='ADD TO CART']"));



        for (WebElement product : products){
            product.click();
            Thread.sleep(2000);
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

       WebElement terms=  driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

       Generics.longPress(driver, terms);
//       Thread.sleep(3000);
        WebElement closeButton= driver.findElement(By.xpath("//*[@text='CLOSE']"));
        Thread.sleep(2000);
        Generics.tapOnElement(driver, closeButton);

    }
}
