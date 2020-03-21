package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class F_driver {
    /**
     * This method retrun WebDriver object based on browser type
     * if you want to use chrome browser, just type chrome in parameter
     * @param browserName
     * @return WebDriver
     */
    public static WebDriver getNewDriver(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("iE")) {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

    }
}
