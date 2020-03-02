package com.automation.test.practice.day02Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver cd = new ChromeDriver();
        cd.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(6000);
        System.out.println("cd.getCurrentUrl() = " + cd.getCurrentUrl());
        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        System.out.println("RETURN single tab's handler "+cd.getWindowHandle());
        //getWindowHandles() - returns id's of all currently opened windows
        System.out.println("RETURN multiple tab's handler " + cd.getWindowHandles());

        String firstPage = cd.getWindowHandle();

        Set<String> handlers = cd.getWindowHandles();
        // how to jump to new window?? i will show you how :
        for (String each : handlers){
            // if my handle is not equals to new handle then switch to the new handle
            if (!cd.getWindowHandle().equals(each)){
                cd.switchTo().window(each);
            }
        }
        System.out.println("cd.getCurrentUrl() = " + cd.getCurrentUrl());
        // after i switch to the new handle i am closing the new handle
        cd.close();
        // as i save the old window's handle earlier under fistPage variable i can recall it and
        // set my current window handle to old one
        cd.switchTo().window(firstPage);
        // i am refreshing to open new window again
        cd.navigate().refresh();
        Thread.sleep(6000);
        // after refresh it did open a new window now i have 2 window
        // i want to close all of them by using .quit() method
        // .close only close one window but .quit() will close all the windows
        cd.quit();



    }
}
