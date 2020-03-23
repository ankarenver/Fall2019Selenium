package com.automation.test.day14;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    private void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        String ele = driver.findElement(By.id("finish")).getText();
        System.out.println(ele);
    }
}
