package com.automation.test.day07;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathPractice {

    static String passwordLocator = "//label[text()='Password']/following-sibling::input";

    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("tomsmith");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();


    }
}
