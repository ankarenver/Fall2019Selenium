package com.automation.test.day09;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp(){
        // setup webdriver
        driver = F_driver.getNewDriver("chrome");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test
    public void GoogleSearch(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> elements = driver.findElements(By.tagName("h3"));

        for (WebElement each : elements){

            if (each.getText().toLowerCase().contains("java")&&!each.getText().isEmpty()){
                System.out.println(each.getText());
            }
        }
    }


}
