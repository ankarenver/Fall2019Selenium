package com.automation.utilities;

public class BrowserUtils {
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
