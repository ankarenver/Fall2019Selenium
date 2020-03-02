package com.automation.test.practice.day02Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Day02_Search {
    public static void main(String[] args) throws Exception {


        // why we use selenium:
        /*
        * Selenium WebDriver - is used to develop test automation scripts for web based applications.
        * web based application - it's a type of application that is used in a browser.
        * Popular browsers: Chrome, Firefox, Opera, Internet Explorer, Edge, Safari.....
        * */

        WebDriverManager.chromedriver().setup();

        WebDriver newDriver = new ChromeDriver();
        // these are different(alternative) webDriver if you want to do test in any of these you should you them
        // since i am have chromeDriver i will use that
//        WebDriver newDriver2 = new SafariDriver();
//        WebDriver newDriver3 = new FirefoxDriver();
//        WebDriver newDriver4 = new InternetExplorerDriver();
        newDriver.manage().window().maximize();
        newDriver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        System.out.println("newDriver.getTitle() = " + newDriver.getTitle());
        System.out.println("newDriver.getCurrentUrl() = " + newDriver.getCurrentUrl());
        newDriver.navigate().to("http://www.facebook.com/");
        System.out.println("newDriver.getTitle() = " + newDriver.getTitle());
        System.out.println("newDriver.getCurrentUrl() = " + newDriver.getCurrentUrl());
        newDriver.navigate().back();
        // locators there are 8 of them based on the properties
        // every thing that locator found is webElement
        WebElement searchElement1 = newDriver.findElement(By.name("field-keywords"));
        // use sendKey method to enter text
        // use Keys.ENTER to click enter
        searchElement1.sendKeys("mac book pro", Keys.ENTER);
        WebElement sort = newDriver.findElement(By.id("a-autoid-0-announce"));
        sort.click();
        Thread.sleep(3000);
        WebElement sort2 = newDriver.findElement(By.id("s-result-sort-select_2"));
        sort2.click();

        Thread.sleep(10000);

        newDriver.close();



    }
}
