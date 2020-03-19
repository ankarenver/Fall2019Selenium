package com.automation.test.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * //how to use javaScriptExecutor?
 * //javaScriptExecutor; it is an interface we can not create object out of it.
 * //But javascript executor and webDriver are like siblings
 * //So we will cast driver to JavascriptExecutor
 * //we convert webDriver object into JavaScriptExecutor
 * //JavascriptExecutor js = (JavascriptExecutor) driver;
 * //interface => they don't have implementation
 * //if you have interface as reference type you can see methods only coming from that interface
 * //you can not see other methods that are in other interfaces
 * //so we will use remoteWebDriver class as reference type :
 * //if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
 * //like this => private RemoteWebDriver driver;
 * //driver.executeScript("window.scrollBy(0, 250)");
 * //you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
 * //JavascriptExecutor js = (JavascriptExecutor) driver;
 */

public class JSExecutor {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.wait(3);
        //scroll down 250 pixels
        // x, y coordinate
        for (int i = 0; i <500 ; i++) {
            js.executeScript("window.scrollBy(0,2500)");
        }
    }

    @Test
    public void scrollUntilElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link);
    }
}
