package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        //  http://practice.cybertekschool.com/dropdown

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select slcSimpleDropdown = new Select(simpleDropdown);  // or driver.findElement(By.id("dropdown));
        slcSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);
        // select your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectYear.selectByVisibleText("1996");
        selectMonth.selectByVisibleText("October");
        selectDay.selectByVisibleText("7");


        // select all months one by one
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement each : months){
            // get the month name and select based on that
            selectMonth.selectByVisibleText(each.getText());
            BrowserUtils.wait(1);
        }


        //
        List<WebElement> days = selectDay.getOptions();
        for (WebElement each : days){
            // get the month name and select based on that
            selectDay.selectByVisibleText(each.getText());
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(2);
        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText() method
        // getText() retrieves visible text from the webelement

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("California");
        BrowserUtils.wait(2);

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement each : states){
            stateSelect.selectByVisibleText(each.getText());
            BrowserUtils.wait(1);
        }





        BrowserUtils.wait(3);
        driver.quit();


    }
}
