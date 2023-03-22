package com.qa.utils;

public class GlobalParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();
    private static ThreadLocal<String> autoAcceptAlerts = new ThreadLocal<>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
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
        GlobalParams params = new GlobalParams();

        params.setPlatformName(System.getProperty("platformName", "iOS"));
        params.setUDID(System.getProperty("udid", "a467064c67a0494575a62811bb0b6937062319fd"));
        params.setDeviceName(System.getProperty("deviceName", "Grandpad QA iPhone 6s"));

        /*
          Android Real Device

         */
//          params.setPlatformName(System.getProperty("platformName", "Android"));
//          params.setUDID(System.getProperty("udid", "1B241FDEE005GG"));
//          params.setDeviceName(System.getProperty("deviceName", "Pixel 6 Pro"));



        switch(params.getPlatformName()){
            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                break;
            case "iOS":
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }


}
