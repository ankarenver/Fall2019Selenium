package com.automation.test.day03;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = F_driver.getNewDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
