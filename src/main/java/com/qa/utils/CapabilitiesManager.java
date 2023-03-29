package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public MutableCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("Setting Capabilities");

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID,params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));

                    //launch existing app
                    //caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    //caps.setCapability("appActivity", props.getProperty("androidAppActivity"));

                    //install app
                    caps.setCapability("appium:app", props.getProperty("androidAppLocation"));

                    //Emulator
                    if(!Objects.equals(props.getProperty("deviceType"), "real")){
                        caps.setCapability("avd", props.getProperty("emulator"));
                        caps.setCapability("avdLaunchTimeout", 180000);
                    }

                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("autoGrantPermissions", "true");

                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username",  System.getenv("SAUCE_USERNAME"));
                    sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    sauceOptions.setCapability("build", "appium-build-ZG9IP");
                    sauceOptions.setCapability("name", "Real Device -Android");
                    caps.setCapability("sauce:options", sauceOptions);
                }

                case "iOS" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("app", props.getProperty("iOSAppLocation"));
                    caps.setCapability("xcodeOrgId", props.getProperty("xcodeOrdId"));
                    caps.setCapability("xcodeSigningId", props.getProperty("xcodeSigningId"));
                    caps.setCapability("autoAcceptAlerts",params.getAutoAcceptAlerts());
                    caps.setCapability("bundleId", "com.grandpad.ios");
                    caps.setCapability("autoAcceptAlerts","true");

                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username",  System.getenv("SAUCE_USERNAME"));
                    sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    sauceOptions.setCapability("build", "appium-build-ZG9IP");
                    sauceOptions.setCapability("name", "Real Device -IOS");
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
