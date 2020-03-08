package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        for (WebElement each : radioButtons){
            // to check if the button is selected you can use isSelected() method returns boolean
            boolean isChoosen = each.isSelected();
            System.out.println(isChoosen);    // returns false now cause be click on it in later in if statement

            if (each.isEnabled()){
                each.click();
                BrowserUtils.wait(2);
                System.out.println("Clicking on: "+each.getAttribute("id"));
            }else {
                System.out.println("Button is not able to click, button is "+each.getAttribute("id"));
            }
        }
        driver.close();





    }
}
