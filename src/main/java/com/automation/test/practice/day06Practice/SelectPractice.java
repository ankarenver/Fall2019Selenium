package com.automation.test.practice.day06Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class SelectPractice {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select newSelection = new Select(driver.findElement(By.id("dropdown")));
        System.out.println(newSelection.getOptions().size());
        for (int i = 0; i <newSelection.getOptions().size(); i++) {
            System.out.println(newSelection.getOptions().get(i).getText());
        }
        newSelection.getOptions().get(1).click();

        Select yearSelection = new Select(driver.findElement(By.id("year")));
        yearSelection.selectByValue("2005");
        BrowserUtils.wait(2);
        yearSelection.selectByIndex(8);
        BrowserUtils.wait(2);
        yearSelection.selectByIndex(yearSelection.getOptions().size()-1);


        List<WebElement> months = new Select(driver.findElement(By.id("month"))).getOptions();
        for (int i = 0; i <months.size() ; i++) {
            System.out.println(months.get(i).getText());
            if(months.get(i).getText().equals("October")){
                months.get(i).click();
                System.out.println("clicking October in java");
            }
        }

        new  Select(driver.findElement(By.id("day"))).getOptions().get(5).click();






    }
}
