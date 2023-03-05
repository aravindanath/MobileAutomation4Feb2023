package day1;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
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

}
