package com.qa.utils;


public class GlobalParamsSauce {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();
    private static ThreadLocal<String> autoAcceptAlerts = new ThreadLocal<>();

    private static ThreadLocal<String> xcodeSigninID = new ThreadLocal<>();
    private static ThreadLocal<String> xcodeOrgId = new ThreadLocal<>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }
    public void setXcodeSignInID(String xcodeSignInID1){
        xcodeSigninID.set(xcodeSignInID1);
    }

    public String getxcodeOrgId(){
        return xcodeOrgId.get();
    }
    public void setxcodeOrgId(String xcodeOrgId1){
        xcodeOrgId.set(xcodeOrgId1);
    }

    public String getXcodeSignInID(){
        return xcodeSigninID.get();
    }
    public void setAutoAcceptAlerts(String autoAcceptAlerts1){
        autoAcceptAlerts.set(autoAcceptAlerts1);
    }

    public String getAutoAcceptAlerts(){
        return autoAcceptAlerts.get();
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


    public void initializeGlobalParams(){
        GlobalParamsSauce params = new GlobalParamsSauce();

        //sauce-real android
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setDeviceName(System.getProperty("deviceName", "Google Pixel 6 Pro"));
        params.setUDID(System.getProperty("udid", "Google_Pixel_6_pro_13_real_us"));

        //params.setPlatformName(System.getProperty("platformName", "iOS"));
        //params.setUDID(System.getProperty("udid", "a467064c67a0494575a62811bb0b6937062319fd"));
        //params.setDeviceName(System.getProperty("deviceName", "iPhone 14 Pro Max"));
        //params.setUDID(System.getProperty("udid", "iPhone_14_Pro_Max_real_us"));
        //params.setXcodeSignInID(System.getProperty("xcodeOrgId","8EEWH47E3V"));
        //params.setxcodeOrgId(System.getProperty("xcodeSigningId","iPhone Developer"));

        switch (params.getPlatformName()) {
            case "Android" -> {
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
            }
            case "iOS" -> {
                //params.setAutoAcceptAlerts(System.getProperty("autoAcceptAlerts", "true"));
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
            }
            default -> throw new IllegalStateException("Invalid Platform Name!");
        }
    }


}
