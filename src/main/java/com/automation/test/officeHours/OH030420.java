package com.automation.test.officeHours;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OH030420 {
    public static void main(String[] args) {

        /*
        * 1. will go to http://automationpractice.com
        * 2. Search for 't-shirt' in a search box + click enter or search button
        * 3. validate you got 'no result' message on UI
        * 4. search for 't-shirt'
        * 5. Validate there was 1 result found
        *
        * */

        WebDriver diver = F_driver.getNewDriver("Chrome");
        diver.get("http://automationpractice.com");
        diver.findElement(By.id("search_query_top")).sendKeys("t-shirt", Keys.ENTER);

        String errorMessage = diver.findElement(By.className("alert alert-warning")).getText();




    }
}
