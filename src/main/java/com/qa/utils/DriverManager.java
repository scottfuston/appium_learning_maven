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

        URL url = new ServerManager().getServer().getUrl();
        //URL url = new URL("https://@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        if(driver == null){
            try{
                switch(params.getPlatformName()){
                    case "Android":
                        utils.log().info("Initializing AndroidDriver");

                        driver = new AndroidDriver(url, new CapabilitiesManager().getCaps());
                        break;

                    case "iOS":
                        utils.log().info("Initializing IOSDriver");

                        driver = new IOSDriver(url, new CapabilitiesManager().getCaps());
                        break;
                }

                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }

                utils.log().info("Driver is initialized");
                utils.log().info("Capabilities: ", driver.getCapabilities());

                DriverManager.driver.set(driver);

            } catch (IOException e) {
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());

                e.printStackTrace();
                throw e;
            }
        }
    }
}
