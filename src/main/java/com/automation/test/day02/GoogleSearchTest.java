package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws  Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(5000);

        // By.name("q") --> name = "q"
        // name - it's one of the selenium locator
        // there are 8 locator
        // we use locators to find elements
        // to choose locator, just use By.locator
        WebElement search = driver.findElement(By.name("q"));
        // once we found an element, how to enter text?
        // to enter text, use sendKeys() method
        // how to press Enter after entering the text?
        // use key.ENTER  ---> perform keyboard click enter
        //keysToSend - name of the parameter, we don't specify it
        search.sendKeys("java", Keys.ENTER);
        Thread.sleep(2000);
        // if you see <a> element, it calls link
        // visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();  //to click on the element
        Thread.sleep(10000);

        driver.close();
    }
}
