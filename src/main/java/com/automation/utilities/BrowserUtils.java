package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static List<String> getTextFromWebElement(List<WebElement> data){
        List<String> result = new ArrayList<>();
        for (WebElement each : data) {
            result.add(each.getText());
        }
        return result;
    }
}
