package com.automation.test.practice.day15Practice;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest2 {

    @Test
    public void test(){
        System.out.println(ConfigurationReader.getProperty("ankar"));
    }
}
