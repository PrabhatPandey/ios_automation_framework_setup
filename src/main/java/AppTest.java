import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

/**
 * Created by prabhat.p on 3/19/17.
 *
 * Refer this tutorial in youtube to set it up.
 *
 * "How to setup iOS automation with XCUITest WebDriverAgent Runner"
 *
 * https://www.youtube.com/watch?v=ySglJIrDVMQ&t=26s
 */
public class AppTest {
    static WebDriver wd;

    @Before
    public void setup() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version","1.6");
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("platformVersion","10.2");
        capabilities.setCapability("deviceName","iPhone 7 Plus");
        capabilities.setCapability("app","/Users/prabhat.p/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
        capabilities.setCapability("bundleId","com.facebook.IntegrationAppsex");

        wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }

    @After
    public void teardown() {
        wd.quit();
    }

    @Test
    public void testOnButton() {
        wd.findElement(By.name("Alerts")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
