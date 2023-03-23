package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public AppiumDriver driver;
    private TestUtils utils = new TestUtils();

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(utils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));

    }
    public void clear(WebElement e,String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }
    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void launchApp() {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).activateApp("com.grandpad.ios");
        }
    }

    public void closeApp() {
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                        getCapability("appPackage").toString());
                break;
            case "iOS":
                ((InteractsWithApps) driver).activateApp("com.grandpad.ios");
        }
    }
}
