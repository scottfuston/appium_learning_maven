import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {


    public static AppiumDriver initializeDriver(String platformName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        caps.setCapability("newCommandTimeout",300);
        URL url = new URL("http://0.0.0.0:4723");
 //       URL url = new URL("https://Jose.Virgen:3cf084ed-3ab3-4120-bfef-0c10716e8c1d@ondemand.us-west-1.saucelabs.com:443/wd/hub");


        switch(platformName){
            case "Android":
                return new AndroidDriver(url,caps);

            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Grandpad QA iPhone 6s");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                caps.setCapability(MobileCapabilityType.UDID,"a467064c67a0494575a62811bb0b6937062319fd");
                caps.setCapability(MobileCapabilityType.APP,"src/test/resources/apps/GrandPad.ipa");
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"15.7");
                caps.setCapability("xcodeOrgId","8EEWH47E3V");
                caps.setCapability("xcodeSigningId","Apple Development");
                caps.setCapability("wdaLocalPort","8100");
                caps.setCapability("autoAcceptAlerts", "true");
                caps.setCapability("bundleId","com.grandpad.ios");
                //caps.setCapability("browserName","Chrome");
//                MutableCapabilities test = new MutableCapabilities();
//                caps.setCapability("appium:deviceName","iPhone.*");
//                caps.setCapability("appium:deviceOrientation", "portrait");
//                caps.setCapability("appium:automationName", "XCUITest");
//                caps.setCapability("xcodeOrgId","8EEWH47E3V");
//                caps.setCapability("xcodeSigningId","Apple Development");
//                caps.setCapability("bundleId","com.grandpad.ios");
//                caps.setCapability("appium:app", "storage:filename=payload.ipa");
//                caps.setCapability("noReset","false");
//                MutableCapabilities sauceOptions = new MutableCapabilities();
//                sauceOptions.setCapability("build", "appium-build-ZG9IP");
//                sauceOptions.setCapability("name", "Jose-IOS");
//                caps.setCapability("sauce:options", sauceOptions);
                return new IOSDriver(url,caps);
        }

        return null;

}
}
