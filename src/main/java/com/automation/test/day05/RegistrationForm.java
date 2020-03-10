package com.automation.test.day05;

import com.automation.utilities.F_driver;
import com.automation.utilities.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");

        // first name
        driver.findElement(By.name("firstname")).sendKeys("SDET");
        // last name
        driver.findElement(By.name("lastname")).sendKeys("Engineer");
        // username
        driver.findElement(By.name("username")).sendKeys("hardFr");
        //  email
        driver.findElement(By.name("email")).sendKeys("sadkjahkjsd@gmail.com");
        // password
        driver.findElement(By.name("password")).sendKeys("superpassword");
        // phone
        driver.findElement(By.name("phone")).sendKeys("456-789-4444");
        // radio button
        driver.findElements(By.name("gender")).get(2).click();   // clicking the 3rd radio button
        // birth day
        driver.findElement(By.name("birthday")).sendKeys("10/5/2006");
        // department
        new Select(driver.findElement(By.name("department"))).getOptions().get(1).click();
        // jobs
        new Select(driver.findElement(By.name("job_title"))).getOptions().get(3).click();
        // languages
        driver.findElement(By.id("inlineCheckbox2")).click();
        // submit
        driver.findElement(By.id("wooden_spoon")).click();

        String actualResult = driver.findElement(By.xpath("//p")).getText();
        String expected = "You've successfully completed registration!";

        Verify.isEquals(actualResult,expected);

        driver.close();






    }
}
