package com.automation.test.day04;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class WarmUp {
    public static void main(String[] args) {

        /**
         * Go to ebay
         * enter search term
         * click on search button
         * print number of results
         *
         * go to amazon
         * enter search term
         * click on search button
         * verify title contains search term
         *
         * Go to wikipedia.org
         * enter search term `selenium webdriver`
         * click on search button
         * click on search result `Selenium (software)`
         * verify url ends with `Selenium_(software)`
         */

        WebDriver driverEbay = F_driver.getNewDriver("Chrome");
        driverEbay.get("http://ebay.com");
        driverEbay.findElement(By.id("gh-ac")).sendKeys("mac book pro", Keys.ENTER);
        String result = driverEbay.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(result);
        driverEbay.close();


        WebDriver driverAmazon = F_driver.getNewDriver("Chrome");
        driverAmazon.get("http://amazon.com");
        driverAmazon.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11 pro",Keys.ENTER);
        String title = driverAmazon.getTitle();
        System.out.println(title);
        if (title.contains("iphone 11 pro")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driverAmazon.close();

        WebDriver driverWiki = F_driver.getNewDriver("Chrome");
        driverWiki.get("http://wikipedia.com");
        driverWiki.findElement(By.cssSelector("[name=\"search\"]")).sendKeys("Selenium (software)",Keys.ENTER);
        String url = driverWiki.getCurrentUrl();
        System.out.println(url);
        if (url.endsWith("Selenium_(software)")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driverWiki.close();











    }
}
