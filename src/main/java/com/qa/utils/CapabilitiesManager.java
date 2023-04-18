package com.qa.utils;

import org.openqa.selenium.MutableCapabilities;

import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public MutableCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("Setting Capabilities");

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("platformVersion", props.getProperty("platformVersion"));
            caps.setCapability("deviceName", params.getDeviceName());
            caps.setCapability("automationName", props.getProperty("automationName"));
            //caps.setCapability("udid", params.getUDID());

            //install app
            caps.setCapability("appium:app", props.getProperty("appLocation"));

            switch (params.getPlatformName()) {
                case "Android" -> {

                    //Emulator
                    //if(!Objects.equals(props.getProperty("deviceType"), "real")){
                    //    caps.setCapability("avdLaunchTimeout", 180000);
                    //    caps.setCapability("avd", params.getAvd());
                    //}


                    //caps.setCapability("avdLaunchTimeout", 180000);
                    //caps.setCapability("avd", "Pixel_6");

                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("autoGrantPermissions", "true");

                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username",  System.getenv("SAUCE_USERNAME"));
                    sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    sauceOptions.setCapability("build", "appium-build-ZG9IP");
                    sauceOptions.setCapability("name", "Android-test");
                    caps.setCapability("sauce:options", sauceOptions);
                }

                case "iOS" -> {
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("autoAcceptAlerts",true);

                    //caps.setCapability("xcodeOrgId", props.getProperty("xcodeOrdId"));
                    //caps.setCapability("xcodeSigningId", props.getProperty("xcodeSigningId"));

                    //👇 not needed if App is provided
                    //caps.setCapability("bundleId", "com.grandpad.ios");

                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    //sauceOptions.setCapability("appiumVersion", "2.0.0-beta.55");
                    sauceOptions.setCapability("username",  System.getenv("SAUCE_USERNAME"));
                    sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    sauceOptions.setCapability("build", "appium-test-build-ZG9IP");
                    sauceOptions.setCapability("name", "IOS-test");
                    caps.setCapability("sauce:options", sauceOptions);
                }
            }

            return caps;

        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
