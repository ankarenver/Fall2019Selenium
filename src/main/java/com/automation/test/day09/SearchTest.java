package com.automation.test.day09;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test
    public void GoogleSearch(){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> elements = driver.findElements(By.tagName("h3"));

        for (WebElement each : elements){

            if (!each.getText().isEmpty()){
                System.out.println(each.getText());
                Assert.assertTrue(each.getText().toLowerCase().contains("java"));
            }
        }
    }



    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java",Keys.ENTER);
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

//        for (int i = 0; i <searchItems.size()-30 ; i++) {
//            searchItems.get(i).click();
//            BrowserUtils.wait(2);
//            driver.navigate().back();
//            searchItems = driver.findElements(By.xpath("//h2//a"));
//        }

        for (WebElement e:searchItems) {
            System.out.println(e.getText());
        }






    }









}
