package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {


        // http://practice.cybertekschool.com/javascript_alerts

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();  // to click on the first button
        BrowserUtils.wait(2);
        // to get the text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();   // to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        System.out.println((expected.equals(actual)? "PASS" : "FAILED"));
        BrowserUtils.wait(5);
        buttons.get(1).click(); // to click on the 2nd button
        // to click cancel
        driver.switchTo().alert().dismiss(); // result must be: You clicked Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if(expected2.equals(actual2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");

        }


        // TASK :
        // click on button #3
        // enter some text: Hello World!
        // verify that result text ends with  Hello World!

        System.out.println("here is task 3 : ");
        BrowserUtils.wait(5);
        buttons.get(2).click();
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();

        if(driver.findElement(By.id("result")).getText().endsWith("Hello World!")){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAILED");
        }







    }
}
