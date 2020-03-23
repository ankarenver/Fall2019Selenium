package com.automation.test.day14;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    /**
     * Go to web orders page
     * Click on "check all" button
     * Verify that all records are selected
     */
    @Test
    public void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkbox = driver.findElements(By.xpath("//table//tr//input[@type='checkbox']"));
        for (WebElement each : checkbox) {
            Assert.assertTrue(each.isSelected());
        }
    }

    /**
     *  go to web orders page
     *  Verify that Steve Johns zip code is 21233
     *  then update his zip code to ctl00_MainContent_fmwOrder_TextBox5
     *  then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode(){
        String oldZipCode = driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();
        Assert.assertEquals(oldZipCode,"21233");
        driver.findElement(By.xpath("//table//tr[4]//td[13]")).click();
        WebElement zip_code = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zip_code.clear();
        zip_code.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        String  newZipCode = driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();
        Assert.assertEquals(newZipCode,"20002");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
