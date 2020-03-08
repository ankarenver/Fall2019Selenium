package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        WebElement blackButton = driver.findElement(By.id("black"));

        //if eligible and visible to click
        if (blackButton.isEnabled()&&blackButton.isDisplayed()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        }else {
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }


        // how do we verify that button clicked
        // returns true, if button clicked
        if (blackButton.isSelected()){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAILED");
        }

    }
}
