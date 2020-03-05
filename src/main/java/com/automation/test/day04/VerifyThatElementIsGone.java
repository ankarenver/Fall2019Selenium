package com.automation.test.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    //http://practice.cybertekschool.com/multiple_buttons

    /**
     * Interview question
     *
     * how to check if element does not exists any more
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        // to find all buttons
        // make sure that you use findElements with s
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println(buttons.size());

        for (WebElement each : buttons){
            each.click();
            Thread.sleep(2000);
            System.out.println(driver.findElement(By.id("result")).getText());

        }


    }
}
