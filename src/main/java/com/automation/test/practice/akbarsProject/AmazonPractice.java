package com.automation.test.practice.akbarsProject;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.F_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonPractice {
    WebDriver driver;
    String URL= "https://www.amazon.com/";
    By searchBy = By.id("twotabsearchtextbox");
    By itemLinkBy = By.xpath("//a[@class='a-link-normal a-text-normal']");
    By itemNameBy = By.id("productTitle");
    By itemPriceBy =By.id("priceblock_ourprice");
    List<Products> allProducts;



    @BeforeMethod
    public void setup(){
        driver = F_driver.getNewDriver("chrome");
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void iphoneSearchTest(){
        driver.findElement(searchBy).sendKeys("iphone", Keys.ENTER);
        BrowserUtils.wait(3);
        List<WebElement> items = driver.findElements(itemLinkBy);
        System.out.println(items.size());
        allProducts = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
            String itemLink = items.get(i).getAttribute("href");
            items.get(i).click();
            BrowserUtils.wait(3);
            String itemName = driver.findElement(itemNameBy).getText();
            String itemPrice = driver.findElement(itemPriceBy).getText().replace("$","").replace(",","");
            BrowserUtils.wait(1);
            double itemPriceInDouble = Double.parseDouble(itemPrice);
            allProducts.add(new Products(itemName,itemPriceInDouble,itemLink));
            driver.navigate().back();
            BrowserUtils.wait(2);
            items = driver.findElements(itemLinkBy);
        }
        System.out.println(allProducts.size());
        System.out.println("-------------------before sorted : --------------------------------------------------------------- ");
        System.out.println(allProducts);
        Collections.sort(allProducts);
        System.out.println("------------------after sorted : ---------------------------------------------------------------------");
        System.out.println(allProducts);

    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
