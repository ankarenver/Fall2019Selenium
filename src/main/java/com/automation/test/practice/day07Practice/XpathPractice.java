package com.automation.test.practice.day07Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XpathPractice {
    public static void main(String[] args) {


//        //tagName[@attribute="value"]
//
//        //tagName[text()="text of element"]

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("https://www.youtube.com/");
//        List<WebElement> goruntu = driver.findElements(By.xpath("//span[@class = 'style-scope ytd-video-meta-block']"));
//        System.out.println(goruntu.size());
//
//        for (int i = 0; i <goruntu.size() ; i++) {
//            System.out.println(goruntu.get(i).getText());
//            goruntu = driver.findElements(By.xpath("//span[@class = 'style-scope ytd-video-meta-block']"));
//        }

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("news today live", Keys.ENTER);
        //button[contains(text(), '1')]
        driver.findElement(By.xpath("//yt-formatted-string[contains(text(), 'LIVE: KTN News - Nairo') ]")).click();







        //button[contains(text(), '1')]

        //button[contains(@onclick, 'button1')]



    }
}
