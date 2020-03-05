package com.automation.test.practice.day04Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = F_driver.getNewDriver("chrme");
        driver.get("http://ebay.com");
        driver.manage().window().maximize();

        WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchElement.sendKeys("mac book pro", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing3\"]/div/div[2]/a/h3")).click();
        driver.navigate().back();
        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class=\"srp-related-searches\"]//span//a"));
        System.out.println(allLinks.size());
        for (WebElement each : allLinks){
            System.out.println(each.getAttribute("href"));
        }


        for (int i = 0; i <allLinks.size()-1; i++){
            allLinks.get(i).click();
            Thread.sleep(5000);
            driver.navigate().back();
            allLinks = driver.findElements(By.xpath("//div[@class=\"srp-related-searches\"]//span//a"));
        }



    }
}
