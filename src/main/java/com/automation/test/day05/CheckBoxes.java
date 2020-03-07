package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = F_driver.getNewDriver("c");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

//        checkBoxes.get(0).click();   // click on first checkbox
//        BrowserUtils.wait(2);
//        checkBoxes.get(1).click();   // click on second checkbox
//        BrowserUtils.wait(2);

        for (int i = 0; i <checkBoxes.size() ; i++) {
            if(checkBoxes.get(i).isDisplayed()&&checkBoxes.get(i).isEnabled()&&(!checkBoxes.get(i).isSelected())){
                checkBoxes.get(i).click();
                System.out.println(i + " is clicked");
            }else {
                System.out.println(i + " is not clicked");
            }
        }




//        driver.quit();
    }
}
