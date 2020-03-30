package com.automation.test.practice.day15Practice;

import org.testng.annotations.Test;

public class SystemPropPractice {

    @Test
    public void systemPro1(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
//        System.out.println(System.getProperty("java.library.path"));
//        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.name"));
        // if you want to add some file path with not hard_code way you can do like this
        System.out.println(System.getProperty("user.home") + "\\download\\any_file_name_you_want");


    }
}
