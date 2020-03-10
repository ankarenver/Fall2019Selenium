package com.automation.test.practice.day05Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxesPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checks = driver.findElements(By.tagName("input"));
        for (WebElement each : checks){
            each.click();
        }

        /**
         * .isEnabled()   - returns true, if button can be clicked, otherwise - false.
         * .isSelected()  - returns true, if button already clicked, otherwise - false.
         * .isDisplayed() - returns true, if element is visible. Applies to any kind of WebElement, not only radio buttons.
         *
         * Priority:
         * 1. element must be present
         * 2. element must be visible
         * 3. element must be enabled
         */

        for (WebElement each : checks){
            if(each.isDisplayed()&&each.isEnabled()&&!each.isSelected()){
                each.click();
            }
        }

        // un clicking the second button
        // you can use get method from list class call the second radio button
        // and clicking it
        checks.get(1).click();

        // to checked which buttons are clicked:
        for (int i = 0; i <checks.size() ; i++) {
            if (checks.get(i).isSelected()) {
                System.out.println(i+1 + " check box is selected");
            }
        }





    }
}
