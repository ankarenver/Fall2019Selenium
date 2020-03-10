package com.automation.test.practice.day05Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> buttons = driver.findElements(By.xpath("//input[@type=\"radio\"]"));
        System.out.println("number of the elements are here: "+buttons.size());

        // clicking all the buttons
        for (WebElement each : buttons){
            each.click();
//            Thread.sleep(1000);
        }

        System.out.println();

        System.out.println(buttons.get(3).getAttribute("id"));
        System.out.println();
        // click if it is yellow
        for (WebElement each : buttons){
            if (each.getAttribute("id").equals("red")){
                each.click();

            }
        }

        System.out.println();

        for (WebElement each : buttons){
            if (!each.isSelected()){
                System.out.println(each.getAttribute("id"));
            }
            if (!each.isEnabled()){
                System.out.println("this is the button that can not click "+ each.getAttribute("id"));
            }
        }

        System.out.println();
        for (WebElement each : buttons){
            if (each.isDisplayed()){
                System.out.println(each.getAttribute("id"));
            }
        }







    }
}
