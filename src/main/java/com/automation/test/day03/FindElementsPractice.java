package com.automation.test.day03;

import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = F_driver.getNewDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement nameInput = driver.findElement(By.name("full_name"));
        nameInput.sendKeys("ankar enver");
        Thread.sleep(2000);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("sjahdja@hotmel.com");
        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.name("wooden_spoon"));
        submit.click();
        Thread.sleep(5000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement masages = driver.findElement(By.className("subheader"));
        String actual = masages.getText();
        System.out.println(actual);

        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test failed");
        }


        driver.navigate().to("http://practice.cybertekschool.com/signup_confirmation");
        WebElement backHome = driver.findElement(By.id("wooden_spoon"));
        backHome.click();
        Thread.sleep(2000);

        driver.close();





    }

}
