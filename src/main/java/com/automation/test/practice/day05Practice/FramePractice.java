package com.automation.test.practice.day05Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePractice {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("https://www.expedia.com/");
        System.out.println(driver.findElement(By.id("primary-header-flight")).getText());

        // now we are in different frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"google_ads_iframe_/23171577/expedia.us_en/home/all/CM2_0\"]")));

        driver.switchTo().defaultContent();
        // after go back to the main frame program now will be able to print second Flights
        System.out.println(driver.findElement(By.id("primary-header-flight")).getText());



        //iframe[@id="google_ads_iframe_/23171577/expedia.us_en/home/all/CM2_0"]
    }
}
