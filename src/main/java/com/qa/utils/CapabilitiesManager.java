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
            utils.log().info("Setting Capabilities...");

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("deviceName", params.getDeviceName());
            caps.setCapability("automationName", params.getAutomationName());
            caps.setCapability("appium:app", params.getAppLocation());

            if(params.getUDID() != null){
                utils.log().info("Setting 'udid' capability");
                caps.setCapability("udid", params.getUDID());
            }

            if(params.getPlatformVersion() != null){
                utils.log().info("Setting 'platformVersion' capability");

                caps.setCapability("platformVersion", params.getPlatformVersion());
            }

            //SAUCELABS CAPABILITIES
            if(new ServerManager().getServer().getUrl().toString().endsWith("/hub")) {
                utils.log().info("Setting Saucelabs " + params.getPlatformName() + " capabilities");

                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
                sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                sauceOptions.setCapability("build", "appium-build-ZG9IP");
                sauceOptions.setCapability("name", params.getPlatformName() + "-test");
                caps.setCapability("sauce:options", sauceOptions);
            }

            switch (params.getPlatformName()) {
                case "Android" -> {
                    utils.log().info("Setting Android capabilities");

                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("autoGrantPermissions", "true");

                    if(params.getAvd() != null){
                        // EMULATOR
                        utils.log().info("Setting AVD Capability: " + params.getAvd());

                        caps.setCapability("avdLaunchTimeout", 180000);
                        caps.setCapability("avd", params.getAvd());

                        //uninstall app and clear all data
                        utils.log().info("Local virtual device: setting 'fullReset' capability");
                        caps.setCapability("fullReset", "true");
                    }
                }

                case "iOS" -> {
                    utils.log().info("Setting iOS capabilities");

                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("autoAcceptAlerts",true);

                    // SIMULATOR
                    if(params.getAppLocation().endsWith(".app.zip")){
                        utils.log().info("Setting 'fullReset' capability");

                        //uninstall app and clear all data
                        caps.setCapability("fullReset", "true");
                    }
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
