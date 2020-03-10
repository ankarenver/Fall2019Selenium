package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);

        // to find the top left frame :
        driver.switchTo().frame("frame-top");   // select top frame
        driver.switchTo().frame("frame-left");  // select the left one on top
        System.out.println(driver.findElement(By.tagName("body")).getText());


        // to find the top right :  but i want to get out of the top left frame and then go to that frame
        driver.switchTo().defaultContent();     // get out of frame
//        driver.switchTo().parentFrame();  // this it top frame

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.tagName("div")).getText());

        // to find the left frame :
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());


        // to find bottom frame  :
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
