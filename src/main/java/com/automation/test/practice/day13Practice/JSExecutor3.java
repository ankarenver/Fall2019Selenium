package com.automation.test.practice.day13Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor3 {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

    @Test
    public void test1(){
        String expected = "Practice";
        String actual =(String)driver.executeScript("return document.title");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void clickTest() {
        driver.findElement(By.linkText("Multiple Buttons")).click();
        BrowserUtils.wait(2);
        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        driver.executeScript("arguments[0].click()",button6);
        BrowserUtils.wait(2);
    }



    @Test
    public void  enterText() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.id("wooden_spoon"));

        driver.executeScript("arguments[0].setAttribute('value','tomsmith')",userName);
        driver.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
        driver.executeScript("arguments[0].click()",submit);

        BrowserUtils.wait(3);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
