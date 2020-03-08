package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelection {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        Select selectLanguages = new Select(driver.findElement(By.name("Languages")));

        // where this select element support selecting multiple options at the same time?
        // this is done by checking the value of  the "Multiple" attribute.
        Boolean isMultiple = selectLanguages.isMultiple();
        System.out.println(isMultiple);

        selectLanguages.selectByVisibleText("Java");
        selectLanguages.selectByVisibleText("Python");
        selectLanguages.selectByVisibleText("C");

        BrowserUtils.wait(5);

        // let's get all selected options
        List<WebElement> languages = selectLanguages.getAllSelectedOptions();
        for (WebElement each : languages){
            System.out.println(each.getText());
            if (each.getText().equals("C")){
                selectLanguages.deselectByVisibleText(each.getText());
            }
        }

        driver.quit();


    }
}
