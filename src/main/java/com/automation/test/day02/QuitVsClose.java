package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {
    public static void main(String[] args) throws Exception{
        // .close() - close 1 window
        // .quit()  - close all windows
        //http://practice.cybertekschool.com/open_new_tab

        WebDriverManager.chromedriver().setup();

        WebDriver diver = new ChromeDriver();
        diver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

//        diver.close();   // .close() - close 1 window
        diver.quit();      // .quit()  - close all windows



    }
}
