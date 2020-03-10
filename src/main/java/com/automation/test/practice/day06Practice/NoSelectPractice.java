package com.automation.test.practice.day06Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectPractice {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement clickThis = driver.findElement(By.id("dropdownMenuLink"));
        clickThis.click();
        // since it is not select so you can not use getOptions method

        List<WebElement> insides = driver.findElements(By.className("dropdown-item"));
        for (int i = 0; i <insides.size(); i++) {
            insides.get(i).click();
            driver.navigate().back();
            driver.findElement(By.id("dropdownMenuLink")).click();
            insides = driver.findElements(By.className("dropdown-item"));
        }






    }
}
