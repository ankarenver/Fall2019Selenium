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

    @Test
    public void verifyRowCount(){
        //  //tbody//ty - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        // if we will get a size of this collection, it automatically equals to number of elements
        // expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }

    /**
     * to get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){
        // td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElement(links));
    }



    //   //table[1]//td[text()='fbach@yahoo.com’]//following-sibling::td/a[text()=‘delete’]
    @Test
    public void task1(){
        WebElement delete = driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']"));
        delete.click();
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        Assert.assertEquals(links.size(), 3);
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}
