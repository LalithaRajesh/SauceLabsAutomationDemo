package com.company;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class BrowserStackCapabilities {

    WebDriver driver;
    public static final String USERNAME = "LalithaRajesh";
    public static final String AUTOMATE_KEY = "18d2db21c6fa413ead9ce56ae8414558";

    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @Parameters({"browser", "browser_version", "os", "os_version"})
    @BeforeMethod
    public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {

        System.out.println("browser name is : " + browserName);
        String methodName = name.getName();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", os);
        caps.setCapability("os_version", os_version);
        caps.setCapability("browser_version", browser_version);
        caps.setCapability("name", methodName);

        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            caps.setCapability("browser", "Firefox");
        }
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Sauce Labs");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        System.out.println(driver.getTitle());

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}