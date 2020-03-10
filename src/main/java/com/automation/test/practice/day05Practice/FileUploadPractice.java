package com.automation.test.practice.day05Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(2);
        // to get the path of any file in your PC you can hold shift + right click + copy as path
        String locationOfFile = "D:\\Cyber-tek\\Class_notes\\03_07_2020\\code_notes.txt";
        driver.findElement(By.id("file-upload")).sendKeys(locationOfFile);
        driver.findElement(By.className("button")).click();




    }
}
