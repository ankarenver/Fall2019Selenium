package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(1);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.getOptions().get(15).click();

        System.out.println(stateSelect.getOptions().get(15).getText());


        BrowserUtils.wait(1);


    }
}
