package com.automation.test.day04;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = F_driver.getNewDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);
        // how to collect all links from the page??
        List<WebElement> allElements = driver.findElements(By.tagName("a"));
        System.out.println(allElements.size());
        for (WebElement each : allElements){
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }
        // another way to print by using forEach:
//        allElements.forEach(each-> System.out.println(each.getText()));


        for (int i = 1; i <allElements.size() ; i++) {
            allElements.get(i).click();
//            Thread.sleep(2000);
            driver.navigate().back();
//            Thread.sleep(2000);
            // refresh list
            allElements = driver.findElements(By.tagName("a"));


        }

        driver.quit();

    }
}
