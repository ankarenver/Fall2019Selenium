package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploading {
    public static void main(String[] args) {

        // cloudFile dose not work should be on your computer

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(2);

        String filePath = System.getProperty("user.dir")+"\\pom.xml";
        String filePath2 = "D:\\Cyber-tek\\Class_notes\\03_07_2020\\code_notes.txt";
        driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys(filePath2);
        driver.findElement(By.id("file-submit")).click();

        System.out.println(filePath);
        // to copy a file in computer you can hold shift and click right click and click copy as path
        //  "C:\Users\Msi\Downloads\Basic Navigation Homework-3.pdf"








    }
}
