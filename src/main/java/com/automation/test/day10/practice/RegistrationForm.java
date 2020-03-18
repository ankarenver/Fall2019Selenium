package com.automation.test.day10.practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegistrationForm {
    private String URL ="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
