
package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class HandlingWebView extends WebViewHandlign {

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

        Generics.scrollToElement(driver,"Jordan 6 Rings");

        Thread.sleep(2000);

        List<WebElement> products1 = driver.findElements(By.xpath
                ("//*[@text='ADD TO CART']"));



        for (WebElement product : products1){
            product.click();
            Thread.sleep(2000);
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(2000);

        String context = driver.getContext();
        System.out.println("Context: "+context);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);
        Set<String> contexts=  driver.getContextHandles();
        for (String con : contexts) {
            System.out.println("Context: "+con);
        }

        driver.context(contexts.toArray()[1].toString());
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: "+title);
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Mobile Automation jobs", Keys.ENTER);


    }
}
