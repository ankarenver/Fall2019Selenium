package com.automation.test.practice.day07Practice;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class XpathPractice2 {
    public static void main(String[] args) {


        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("firstname")).sendKeys("sem");
        driver.findElement(By.name("lastname")).sendKeys("esam");
        driver.findElement(By.name("reg_email__")).sendKeys("semesam12@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("semesam12@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Esam159789E*");

        Select month = new Select(driver.findElement(By.id("month")));
        month.getOptions().get(5).click();
        Select day = new Select(driver.findElement(By.id("day")));
        day.getOptions().get(23).click();
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1953");
        driver.findElement(By.id("u_0_a")).click();
        driver.findElement(By.name("websubmit")).click();



    }
}
