package com.automation.test.day15;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
        String color = ConfigurationReader.getProperty("color");
        System.out.println(color);
        String storeManager = ConfigurationReader.getProperty("store_manager");
        System.out.println(storeManager);
        String password = ConfigurationReader.getProperty("password");
        System.out.println(password);
        System.out.println(ConfigurationReader.getProperty("password"));
        System.out.println(ConfigurationReader.getProperty("qa2"));
    }
}
