package com.automation.test.day15;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        // flexible path to download folder
        System.out.println(System.getProperty("user.home") + "\\Downloads");
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));


    }

}
