package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
//        driver.findElement(By.linkText("Google")).click();


        /**
         * //INTERVIEW QUESTION
         * //From selenium perspective there are 2 types of dropdowns : select and other
         * //To handle select drop-downs, use Select class from selenium
         * //In case of any other dropdown, just click on, wait until options become visible and click on the option
         * //how to determine which option is drop down and which is not?
         * //just look at tag name, if it is select than dropdown type is select
         */


        List<WebElement> dropDowns = driver.findElements(By.className("dropdown-item"));
        for (int i = 0; i <dropDowns.size(); i++) {
            System.out.println(dropDowns.get(i).getAttribute("href"));
            dropDowns.get(i).click();
            driver.navigate().back();
            driver.findElement(By.id("dropdownMenuLink")).click();
            dropDowns = driver.findElements(By.className("dropdown-item"));
        }
        driver.quit();
    }
}
