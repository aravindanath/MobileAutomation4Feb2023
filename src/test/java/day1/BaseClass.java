package day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {

        DesiredCapabilities dc=  new DesiredCapabilities();
        dc.setCapability("platformName", Platform.ANDROID);
        dc.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        dc.setCapability("deviceName","Test Device");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
        dc.setCapability("appPackage","com.androidsample.generalstore");
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/"),dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
