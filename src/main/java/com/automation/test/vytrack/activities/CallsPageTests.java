package com.automation.test.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    public WebDriver driver;
    public static String URL = "https://qa2.vytrack.com/user/login";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get(URL);
        actions = new Actions(driver);
        driver.findElement(userNameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        BrowserUtils.wait(5);
        Assert.assertTrue(logCallBtnElement.isDisplayed());
    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);
        WebElement s = driver.findElement(By.cssSelector("a[title=\"Create Calendar event\"]"));
        BrowserUtils.wait(5);
        Assert.assertTrue(s.isDisplayed());


    }

}
