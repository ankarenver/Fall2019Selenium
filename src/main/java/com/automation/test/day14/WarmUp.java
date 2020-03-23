package com.automation.test.day14;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * Warm-up task for 15 minutes:
 * Go to http://practice.cybertekschool.com/tables
 * Click on "Last name" column name
 * Verfiy that table is sorted by last name in alphabetic order.
 */


/**
 * The Java String compareTo() method is used for comparing two strings lexicographically.
 * Each character of both the strings is converted into a Unicode value for comparison.
 * If both the strings are equal then this method returns 0 else it returns positive or negative value.
 * The result is positive if the first string is lexicographically greater than
 * the second string else the result would be negative.
 * This method is coming from Comparable interface.
 * if you want ot be able to sort collection of some class
 * you need to implement this interface
 * and override compareTo method
 * "a".compareTo("b") = -1
 * 61 - 62 = -1
 * a is before b
 * "a".compareTo("a")
 * 61 - 61 = 0
 * 0 means 2 strings are equals
 */

public class WarmUp {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @Test
    public void test(){
        List<WebElement> beforeSortedNames = driver.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
        List<String> namesInStringBefore = BrowserUtils.getTextFromWebElement(beforeSortedNames);
        Collections.sort(namesInStringBefore);
        System.out.println(namesInStringBefore);

        WebElement last_name = driver.findElement(By.xpath("//table[1]//thead//th[1]"));
        last_name.click();
        List<WebElement> afterSortedNames = driver.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
        List<String> namesInStringAfter = BrowserUtils.getTextFromWebElement(afterSortedNames);
        Assert.assertEquals(namesInStringAfter,namesInStringBefore);
        System.out.println(namesInStringAfter);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

