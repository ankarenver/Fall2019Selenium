package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation1 {
    public static void main(String[] args) throws Exception{


        // to stat selenium script we need:
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium everything starts from WebDriver interface
        driver.get("http://google.com");  // to open a website
        driver.manage().window().maximize();   // to maximize browser

        Thread.sleep(5000);  // for demo , wait 5 seconds
        //method that return page title
        //you can also see it as tab name, in the browser
        String title = driver.getTitle();//returns <title>Some title</title> text
        System.out.println("Title is..."+title);

        String expectedTitle = "google";
        if (expectedTitle.equalsIgnoreCase(title)){
            System.out.println("Test pass");
        }else {
            System.out.println("Test failed");
        }

        driver.navigate().to("http://amazon.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        verifyEquals(driver.getTitle(),"google");


        driver.close();  // to close browser
    }

    public static void verifyEquals(String str1, String str2){
        if(str1.equalsIgnoreCase(str2)){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAILED");
        }
    }



}
