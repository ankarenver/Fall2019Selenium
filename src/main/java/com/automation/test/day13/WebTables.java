package com.automation.test.day13;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/tables");

    }

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        // th - represent table header cells
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
//        for (WebElement columnName : columnNames) {
//            System.out.println(columnName.getText());
//        }
        List<String> clmNames = BrowserUtils.getTextFromWebElement(columnNames);
        Assert.assertEquals(clmNames,expected);


    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}
