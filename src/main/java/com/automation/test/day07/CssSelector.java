package com.automation.test.day07;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CssSelector {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(driver.findElement(By.cssSelector(".h3")).getText());
        System.out.println(driver.findElement(By.cssSelector(".btn btn-primary")).getText());



    }
}
