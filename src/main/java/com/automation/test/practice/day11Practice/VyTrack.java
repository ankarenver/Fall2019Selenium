package com.automation.test.practice.day11Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrack {
    private WebDriver driver;
    public static String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get(URL);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(6);
        WebElement activities =driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]"));
        actions.moveToElement(activities).perform();
        BrowserUtils.wait(2);
        WebElement calls = driver.findElement(By.linkText("Calls"));
        actions.moveToElement(calls).perform();
        BrowserUtils.wait(2);
        WebElement createCalendar = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(createCalendar).perform();
        BrowserUtils.wait(2);




    }
}
