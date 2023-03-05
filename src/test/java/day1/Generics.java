package day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;


public class Generics {



    public static void scrollToElement(WebDriver driver, String text){
        String scrollToString = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));";
        ((AndroidDriver)driver).findElementByAndroidUIAutomator(scrollToString);
    }


    public static void scrollToElementAndClick(WebDriver driver, String text){
        String scrollToString = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));";
        ((AndroidDriver)driver).findElementByAndroidUIAutomator(scrollToString).click();
    }

    public static void scrollToEnd(WebDriver driver) {
        try {

            ((AndroidDriver) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(9);");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void longPress(WebDriver driver,WebElement element){
        TouchAction tc = new TouchAction((PerformsTouchActions) driver);
        tc.longPress(longPressOptions().withElement(element(element))
                .withDuration(ofSeconds(2))).perform();
    }

    public static void tapOnElement(WebDriver driver,WebElement element){
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(tapOptions().withElement(element(element)).withTapsCount(1)).perform();
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

    /**
     * verticalSwipeByPercentages(0.6, 0.3, 0.5);

     */
    public static void verticalSwipeByPercentages(WebDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction((PerformsTouchActions) driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
}
