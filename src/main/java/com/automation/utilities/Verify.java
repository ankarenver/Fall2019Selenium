package com.automation.utilities;

import org.openqa.selenium.By;

public class Verify {
    public static void isEquals(String str1, String str2){
        if(str1.equals(str2)){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAILED");
        }
    }
}
