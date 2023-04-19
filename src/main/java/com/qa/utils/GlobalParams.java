package com.qa.utils;

import java.io.IOException;
import java.util.Properties;

public class GlobalParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();
    private static ThreadLocal<String> avd = new ThreadLocal<String>();
    private static  ThreadLocal<String> automationName = new ThreadLocal<String>();
    private static  ThreadLocal<String> appLocation = new ThreadLocal<String>();
    private static  ThreadLocal<String> platformVersion = new ThreadLocal<String>();

    public void setPlatformVersion(String platformVersion1){
        platformVersion.set(platformVersion1);
    }

    public String getPlatformVersion(){
        return platformVersion.get();
    }

    public void setAppLocation(String appLocation1){
        appLocation.set(appLocation1);
    }

    public String getAppLocation(){
        return appLocation.get();
    }

    public void setAutomationName(String automationName1){
        automationName.set(automationName1);
    }

    public String getAutomationName(){
        return automationName.get();
    }

    public void setAvd(String avd1){
        avd.set(avd1);
    }

    public String getAvd(){
        return avd.get();
    }

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    public void initializeGlobalParams() throws IOException {
        //TESTNG
        //testng cannot use the System properties as we did below. (junit only)

        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        TestUtils utils = new TestUtils();

        //params.setPlatformName(System.getProperty("platformName", props.getProperty("defaultPlatformName")));
        //utils.log().info("Setting platformName param: " + params.getPlatformName());

        //params.setDeviceName(System.getProperty("deviceName", props.getProperty("defaultDeviceName")));
        //utils.log().info("Setting deviceName param: " + params.getDeviceName());

        //params.setUDID(System.getProperty("udid", props.getProperty("defaultUDID")));
        //utils.log().info("Setting udid param: " + params.getUDID());

        switch(params.getPlatformName()){
            case "Android":
                utils.log().info("Setting Android ports");

                params.setSystemPort(System.getProperty("systemPort", "10000"));
                utils.log().info("Setting systemPort param: " + params.getSystemPort());

                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                utils.log().info("Setting chromeDriverPort param: " + params.getChromeDriverPort());
                break;

            case "iOS":
                utils.log().info("Setting IOS ports");

                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                utils.log().info("Setting wdaLocalPort param: " + params.getWebkitDebugProxyPort());

                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                utils.log().info("Setting webkitDebugProxyPort param: " + params.getWebkitDebugProxyPort());
                break;

            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }


}
