package day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class ReadSMS extends  BaseClass{

    @Test
    public void test() throws InterruptedException {

        driver.sendSMS("(650) 555-1212","Hi Arvind OTP 12345 is for swiggy txn");
        Thread.sleep(2000);
        driver.openNotifications();
        String otp =  driver.findElement(By.xpath("(//android.widget.Button[\"starts-with(@text,'Copy')\"])[1]")).getText().replace("Copy","").replace("\"", "");
        System.out.println("OTP: "+ otp);
        driver.runAppInBackground(ofSeconds(1));
        Thread.sleep(2000);
        driver.launchApp();
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(otp);

    }

    public static void swipeSlight(WebDriver driver) {
        AppiumDriver aDriver = (AppiumDriver) driver;
        TouchAction touchAction = new TouchAction(aDriver);
        Dimension size = aDriver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width / 2);
        int endy = (int) (size.height * 0.5);
        int starty = (int) (size.height * 0.6);
                touchAction.press(point(startx, starty))
                        .waitAction(waitOptions(ofSeconds(1)))
                        .moveTo(point(startx, endy)).release().perform(); // Absolute final Co-ordinates
    }


}
