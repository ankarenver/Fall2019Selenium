package com.automation.test.day07;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ebay {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("CHROME");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//a[text()='Toys']")).click();


    }

}
