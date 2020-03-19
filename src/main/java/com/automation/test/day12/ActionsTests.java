package com.automation.test.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * //builder pattern => you put one method then you can take action
 * //builder pattern == chaining methods
 * //what is build?
 * //if you have multiple actions you have to put build
 * //to combine a couple of actions.
 * //build() is needed when you have couple of actions
 * //build combines the action; perform; starts the action
 * //in this example; first we move to one image then second so we used build
 * //always end with perform
 * //perform does not click, it starts the action, execute the event
 * //you can perform click, drag and drop etc
 * //actions class has different implementations
 * //moveToElement returns instance of action class that's why we can chain them
 */

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 =driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        // build() is needed when you have couple of actions
        // always end with perform()
        actions.moveToElement(img1).pause(2000).moveToElement(img2).pause(2000).moveToElement(img3).build().perform();


        // hover on th first image
        // verify that  name user1 is displayed
        // hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("(//div[@class='figcaption']//h5)[1]"));
        Assert.assertTrue(imgText1.isDisplayed());

        // move to second image
        BrowserUtils.wait(2);

        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("(//div[@class='figcaption']//h5)[2]"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void hoverOnjqueryMenu(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        // hover on "enable"
        // hover on "downloads"  -->> click on PDF
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enable).pause(2000).moveToElement(download).pause(2000).click(pdf).pause(2000).build().perform();

    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(draggable,target).pause(2000).perform();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

}
