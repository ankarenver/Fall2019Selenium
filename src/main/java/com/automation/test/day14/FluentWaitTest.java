package com.automation.test.day14;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = F_driver.getNewDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    private void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(3)).
                ignoring(NoSuchElementException.class);

        WebElement submitBtn = wait.until(driver -> driver.findElement(By.xpath("//button[@type='submit']")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        submitBtn.click();
    }


}
