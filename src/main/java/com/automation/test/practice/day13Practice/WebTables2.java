package com.automation.test.practice.day13Practice;

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
import java.util.concurrent.TimeUnit;

public class WebTables2 {

    private WebDriver driver;

    @BeforeMethod
    public void  setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/tables");
    }


    @Test
    public void getColumnName(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> headers = driver.findElements(By.xpath("//table[1]//th"));
        List<String> actual = BrowserUtils.getTextFromWebElement(headers);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifyRowCount(){
        //  //table[1]//tbody//tr you will get row count
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        System.out.println(rows.size());  // 4
    }

    @Test(description = "to get specific column, skip row index, and just provide td index")
    public void getSpecificColumn(){
        List<WebElement> websites = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        websites.forEach(each-> System.out.println(each.getText()));
    }
    @Test
    public void clickDeleteBtn(){
        driver.findElement(By.xpath("//table[1]//tbody//tr//td[text()='John']//following-sibling::td//a[text()='delete']")).click();
        List<WebElement> afterDelete = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        System.out.printf("here is the number of column %d",afterDelete.size());
    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }


}
