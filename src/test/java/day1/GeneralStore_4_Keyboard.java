package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralStore_4_Keyboard extends  BaseClass{

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
        Thread.sleep(2000);

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(2000);

        List<WebElement> price = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productPrice']"));

        ArrayList<Float> prices = new ArrayList<Float>();


        for(WebElement pr : price){
            Float value = Float.parseFloat(pr.getText().replace("$", ""));
            prices.add(value);
        }


        float productPrice = prices.get(0)+prices.get(1);
        System.out.println(prices);
       String totalPrc  = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$", "");
        float finalPrice = Float.parseFloat(totalPrc);
        System.out.println("finalPrice "+ finalPrice);
        if(finalPrice == productPrice){
            System.out.println("Price matches");
        }else{
            System.out.println("Price not matches");
        }

    }
}
