package com.automation.test.day13;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");

    }


    @Test
    public void verifyTitle(){
        String expected = "Practice";
        // we create javascriptExecutor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // executeScript - this method executes javascript code
        // we provide js code as a String
        // return document.title - javascript code
        // document - represents HTML page
        String actualTitle = (String) js.executeScript("return document.title");
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expected);
    }

    @Test
    public void clickTest(){
        driver.findElement(By.linkText("Multiple Buttons")).click();
        BrowserUtils.wait(2);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // after "" you can list webelement that will be used as part of your javascript code
        // it's varargs, so you can list 0+
        // arguments - listed after use index to get specific webelement
        // webelement arguments = {element, link, link2};
        js.executeScript("arguments[0].click()",button6);
        BrowserUtils.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");

    }

    @Test
    public void  enterText(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        // to get text from input box - read attribute "value"
        // to enter text - set attribute "value"
        js.executeScript("arguments[0].setAttribute('value','tomsmith')",userName);
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",submit);
        BrowserUtils.wait(2);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement(){
        //href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link);
    }


    @Test
    public void scrollTest() {
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0, 1000)");
            BrowserUtils.wait(1);
        }
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
