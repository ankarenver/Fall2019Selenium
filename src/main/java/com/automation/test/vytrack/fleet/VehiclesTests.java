package com.automation.test.vytrack.fleet;

import com.automation.test.vytrack.login.LoginPageTests;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class VehiclesTests extends LoginPageTests{

    @Test
    public void verifyPageSubTitle(){

        loginStoreManager();
        driver.findElements(By.xpath("//span[@class='title title-level-1']")).get(1).click();
        BrowserUtils.wait(1);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(1);
        String actual =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String expected = "All Cars";
        Assert.assertEquals(actual,expected);
        /**
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.name("dsa"))).click().perform();
         */
    }
    @Test
    public void verifyPageNumber(){
        loginStoreManager();
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElements(By.xpath("//span[@class='title title-level-1']")).get(1)).perform();
        BrowserUtils.wait(4);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(4);
        String actual = driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value");
        String expected = "1";
        Assert.assertEquals(actual,expected);

    }
}
