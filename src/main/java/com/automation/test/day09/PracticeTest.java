package com.automation.test.day09;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest {
     private WebDriver driver;
    /**
     * Create a class called PracticeTests
     * - setup before/after methods
     * 	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
     * 	- in after method - just close webdriver.
     * - create a test called lofinTest
     * 	- go to “Form Authentication” page
     * 	- enter valid credentials
     * 	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
     */

    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");


        /**
         *         //ChromeOptions - use to customize browser for tests
         *         ChromeOptions chromeOptions = new ChromeOptions();
         *         //to ignore "Your connection is not private issue"
         *         chromeOptions.setAcceptInsecureCerts(true);
         *         // provide chromeOptions object into chromedriver constructor
         *         driver = new ChromeDriver(chromeOptions);
         *
         */
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword"+ Keys.ENTER);
//        driver.findElement(By.id("wooden_spoon")).click();
        String msg= driver.findElement(By.tagName("h4")).getText();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(msg,expected);



    }

    @Test
    public void forgetPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("asada@gmail.com");
        driver.findElement(By.cssSelector("#form_submit")).click();

        String expected = driver.findElement(By.tagName("h4")).getText();
        String actual = "Your e-mail's been sent!";

        Assert.assertEquals(expected,actual);

    }

    /**
     * /**
     *  * TASK for 5 minutes
     *  * Given user is on the practice landing page
     *  * When user navigates to "Checkboxes" page
     *  * And clicks on checkbox #1
     *  * Then user verifies that checkbox #1 is selected
     *  */


    @Test
    public void checkBoxTest1(){
        driver.navigate().to("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
        BrowserUtils.wait(5);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());

    }








}
