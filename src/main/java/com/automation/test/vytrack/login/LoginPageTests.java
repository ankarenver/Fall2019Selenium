package com.automation.test.vytrack.login;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
    public WebDriver driver;
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    public String URL = "https://qa2.vytrack.com/user/login";

    //CREDENTIALS FOR store manager
    public String username = "storemanager85";
    public String password = "UserUser123";

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        // if webdriver object alive
        if (driver != null){
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;

        }
    }

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(By.id("prependedInput")).sendKeys("invalidusername");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        String msg = driver.findElement(By.xpath("//div[@class='alert alert-error']/div")).getText();
        BrowserUtils.wait(2);
        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-error']/div")).isDisplayed());

    }

    @Test(description = "Login as store manager and verify that title is equals to dashboard")
    public void loginStoreManager(){
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(2);
        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(expected,actual,"Page title is not correct!");

    }
}
