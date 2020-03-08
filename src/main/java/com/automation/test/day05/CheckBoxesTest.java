package com.automation.test.day05;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // verify that 1st checkbox is not selected and 2nd is selected

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        System.out.println((!checkboxes.get(0).isSelected()&&checkboxes.get(1).isSelected())? "TEST PASS": "TEST FILED");
        driver.close();




    }
}
