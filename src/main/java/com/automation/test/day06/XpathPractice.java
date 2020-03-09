package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        // value can be inside '' or ""
        // if you do not know the tag name, or want to skip tag name, use *
        // for example //*[@onclick='button1()']  | * means any tag name
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick=\"button1()\"]"));
        btn1.click();
        System.out.println(driver.findElement(By.id("result")).getText());

        // click on button#2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(driver.findElement(By.id("result")).getText());


    }
}
