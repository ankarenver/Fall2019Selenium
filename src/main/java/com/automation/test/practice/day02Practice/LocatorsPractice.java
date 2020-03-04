package com.automation.test.practice.day02Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {
    public static void main(String[] args) throws Exception{

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("http://google.com");
//
//        WebElement btn1 = driver.findElement(By.id("hplogo"));
//        btn1.click();
//        Thread.sleep(3000);
//
//        driver.close();




        //==================================== find element by tagName============================================

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        WebElement ele = driver.findElement(By.tagName("h1"));
        System.out.println(ele.getText());


    }
}
