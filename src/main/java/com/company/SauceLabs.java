package com.company;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {
    public static final String USERNAME = "LalithaRajesh";
    public static final String ACCESS_KEY = "18d2db21c6fa413ead9ce56ae8414558";

    public static void main(String[] args) throws Exception {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", "Web Driver demo Test");
        sauceOptions.setCapability("tags", "tag1");
        sauceOptions.setCapability("build", "build-1234");
        sauceOptions.setCapability("username", USERNAME);
        sauceOptions.setCapability("accessKey", ACCESS_KEY);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", "Windows 10");
        options.setCapability("browserVersion", "79.0");
        options.setCapability("sauce:options", sauceOptions);
        WebDriver driver = new RemoteWebDriver(new URL("https://LalithaRajesh:18d2db21c6fa413ead9ce56ae8414558@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);

        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Sauce Labs");
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        System.out.println(driver.getTitle());

        driver.quit();
        System.out.println("Test Completed");
    }
}

