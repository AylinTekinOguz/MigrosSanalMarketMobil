package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    protected static AppiumDriver<MobileElement> appiumDriver;


    @Before
    public static void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage","com.inomera.sm");
        capabilities.setCapability("appActivity","com.inomera.sm.ui.home.HomeActivity");
        capabilities.setCapability("platformName","Android");
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


    }

    @After
    public static void closeDriver(){
        if (appiumDriver !=null){
            appiumDriver.quit();
        }
    }
}
