package com.automation.test.practice.day04Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LocatorsPracticeXpath {
    public static void main(String[] args) throws Exception{

        // There are two way of using Xpath:
        // 1. absolute Xpath
        //
        // 2. relative Xpath
        //

        WebDriver driver = F_driver.getNewDriver("C");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("mac book", Keys.ENTER);
        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@class=\"s-item__link\"]"));
        System.out.println(allLinks.size());
        allLinks.forEach(each-> System.out.println(each.getAttribute("href")));

        List<String> prices = new ArrayList<>();

        for (int i = 10; i <allLinks.size() ; i++) {
            allLinks.get(i).click();
            Thread.sleep(2000);
            System.out.println(driver.findElement(By.xpath("//span[@itemprop=\"price\"]")).getText());
            prices.add(driver.findElement(By.xpath("//span[@itemprop=\"price\"]")).getText());
            driver.navigate().back();
            Thread.sleep(2000);
            allLinks = driver.findElements(By.xpath("//a[@class=\"s-item__link\"]"));

        }
        System.out.println(prices);


    }
}
