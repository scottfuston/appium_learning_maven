package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
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
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID,params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,params.getDeviceName());
            //caps.setCapability("xcodeOrgId", props.getProperty("xcodeOrdId"));
            //caps.setCapability("xcodeSigningId", props.getProperty("xcodeSigningId"));
         //   caps.setCapability("autoAcceptAlerts",params.getAutoAcceptAlerts());

            switch (params.getPlatformName()) {
                case "Android" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    caps.setCapability("autoGrantPermissions", "true");

                    //  String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    //String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    //        + File.separator + "resources" + File.separator + "apps" + File.separator + "PUMA-HEAD-47926-v8a.apk";
                    //utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("appium:app", props.getProperty("androidAppLocation"));
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username",  System.getenv("SAUCE_USERNAME"));
                    sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
                    sauceOptions.setCapability("build", "appium-build-ZG9IP");
                    sauceOptions.setCapability("name", "Real Device -Android");
                    caps.setCapability("sauce:options", sauceOptions);

                    //caps.setCapability("app", androidAppUrl);

                }

                case "iOS" -> {
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    //       String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "GrandPad.ipa";
//                    utils.log().info("appUrl is" + iOSAppUrl);
//                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
//                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
               //     caps.setCapability("app", "storage:filename=serval-master-6.454.25529.ipa");
                    caps.setCapability("bundleId", "com.grandpad.ios");
                  //  caps.setCapability("app", "src/test/resources/apps/GrandPad.ipa");
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
