package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {


        // to stat selenium script we need:
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver00 = new ChromeDriver();
        WebDriver driver01 = new SafariDriver();
        // in selenium everything starts from WebDriver interface
        driver00.get("http://google.com");  // to open a website

        Thread.sleep(5000);  // for demo , wait 5 seconds

        driver00.close();  // to close browser














    }
}
