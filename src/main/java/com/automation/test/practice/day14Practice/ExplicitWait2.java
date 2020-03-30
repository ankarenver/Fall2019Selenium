package com.automation.test.practice.day14Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait2 {
    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void waitForTitle(){
        wait.until(ExpectedConditions.titleContains("oogle"));
        System.out.println(driver.getTitle());
    }

    @Test
    public void WaitForVisibility(){
        driver.navigate().to("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"))));


        
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
