package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserLaunch {

    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {

        DesiredCapabilities dc=  new DesiredCapabilities();
        dc.setCapability("platformName", Platform.ANDROID);
        dc.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        dc.setCapability("deviceName","Test Device");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("browserName","Chrome");
        dc.setCapability("chromedriverExecutable","/Users/aravindanathdm/Documents/PiplineDemo/MobileAutomation4Feb2023/driver/chromedriver");
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/"),dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get("https://www.google.com");
       String title = driver.getTitle();
       System.out.println("Title"+  title);
       driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div[1]/div/input")).sendKeys("Mobile Automation jobs", Keys.ENTER);
    }
}
