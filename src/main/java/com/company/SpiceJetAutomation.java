package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpiceJetAutomation extends BrowserStackCapabilities {


    public void doLogin() throws InterruptedException {
        driver.get("http://www.spicejet.com");
        driver.findElement(By.id("divpaxinfo")).click();
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("3");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    public void checkIfCheckBoxSelectedUsingFalseCondition() throws InterruptedException {
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
    }

    @Test(priority = 2)
    public void checkIfCheckBoxSelectedUsingTrueCondition() throws InterruptedException {
        doLogin();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
    }

    @Test(priority = 3)
    public void countCheckBoxes(){
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        for(int i =0; i<6; i++){
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"3 Adult");
        }
    }
    
}

