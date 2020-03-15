package com.automation.test.practice.day09Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestNGPractice {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("before method");
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get("https://www.amazon.com/");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("after method");
        driver.quit();
    }

    @Test(priority = 1)
    public void getAllLinks(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook pro"+ Keys.ENTER);
        List<WebElement> allLinks = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        allLinks.forEach(each-> System.out.println(each.getText()));
        for (WebElement each : allLinks){
            Assert.assertTrue(each.getText().toLowerCase().contains("macbook"));
        }
    }
    @Test(priority = 2)
    public void getPrice(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook pro"+ Keys.ENTER);
        List<WebElement> allPrice = driver.findElements(By.className("a-price-whole"));
        allPrice.forEach(each-> System.out.println(each.getText()));
    }

    @Test(priority = 0)
    public void sortByFeature(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook pro"+ Keys.ENTER);
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("16 to 16.9 Inches")).click();
        driver.findElement(By.linkText("13 to 13.9 Inches")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("s-result-sort-select_2")).click();
        BrowserUtils.wait(3);
        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        allPrices.forEach(each-> System.out.println(each.getText()));

        BrowserUtils.wait(3);
    }
}
