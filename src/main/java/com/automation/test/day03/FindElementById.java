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

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        String href = driver.findElement(By.partialLinkText("Logout")).getAttribute("href");
        String Class = driver.findElement(By.partialLinkText("Logout")).getAttribute("class");
        // let's click on Logout button. it looks like a button, but it's actually a link
        // every element with <a> tag is a link
        // if you have some space and you are not sure to include it you can use partialLinkText instead of linkText
        driver.findElement(By.partialLinkText("Logout")).click();

        System.out.println(href);
        System.out.println(Class);

        // Enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("ankar");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("sdasdafsa");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();

        System.out.println(driver.findElement(By.id("flash-messages")).getText());
        Thread.sleep(4000);
        driver.quit();
    }
}
