package com.automation.test.practice.day12Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionPractice {
    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test(){
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        actions.moveToElement(enable).perform();
        BrowserUtils.wait(2);
        WebElement download = driver.findElement(By.id("ui-id-4"));
        actions.moveToElement(download).perform();
        BrowserUtils.wait(2);
        WebElement excel = driver.findElement(By.id("ui-id-7"));
        actions.click(excel).perform();
        BrowserUtils.wait(2);
    }

    @Test
    public void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(draggable,target).perform();
    }
}
