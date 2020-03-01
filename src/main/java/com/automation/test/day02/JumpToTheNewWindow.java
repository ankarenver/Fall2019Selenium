package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver d = new ChromeDriver();
        d.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);
        // every window has some id, this id calls window handle
        // based on window handle, we can switch
        String windowHandle = d.getWindowHandle();
        System.out.println(windowHandle);

        Set<String> windowHandles = d.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("before switch" + d.getCurrentUrl());

        for (String each : windowHandles){

            if (!each.equals(windowHandle)){
                d.switchTo().window(each);
            }
        }

        System.out.println("after switch" + d.getCurrentUrl());
        d.close();


    }
}
