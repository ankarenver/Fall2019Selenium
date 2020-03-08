package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("dd");
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(3);
        // Before looking for that element, we need to jump to that frame
        // you can specify: name, id, index, or WebElement of the frame
        // it's like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");
        // now, this content will be visible
        System.out.println(driver.findElement(By.id("tinymce")).getText());

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("hello sadads");
        BrowserUtils.wait(4);


        // Exit from the frame
        driver.switchTo().defaultContent();
        driver.close();

    }
}
