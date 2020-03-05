package com.automation.test.practice.day04Practice.ebayMacBookSearch;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindMacBook {
    public static void main(String[] args) throws Exception{
        WebDriver driver = F_driver.getNewDriver("c");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("macbook pro", Keys.ENTER);
        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@class=\"s-item__link\"]"));
        System.out.println(allLinks.size());
        allLinks.forEach(each-> System.out.println(each.getAttribute("href")));

//        for (int i = 0; i <allLinks.size() ; i++) {
            allLinks.get(1).click();
            Thread.sleep(2000);
        // now i can not find the element in web page such as item specifics ram processor etc....

//        }


    }
}
