package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();
    Properties props = new PropertyManager().getProps();

    public DriverManager() throws IOException {
    }

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        URL url = new URL(props.getProperty("appiumURL"));

        if(driver == null){
            try{
                utils.log().info("initializing Appium driver");

                switch(params.getPlatformName()){
                    case "Android":
                          driver = new AndroidDriver(url, new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                          driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                }

                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }

                utils.log().info("Driver is initialized");

                DriverManager.driver.set(driver);
            } catch (IOException e) {
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());

                e.printStackTrace();
                throw e;
            }
        }

    }

}
