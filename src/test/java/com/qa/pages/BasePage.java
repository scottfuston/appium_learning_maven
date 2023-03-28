package com.qa.pages;

import com.google.common.collect.ImmutableMap;
import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.PropertyManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public AppiumDriver driver;
    GlobalParams params = new GlobalParams();
    Properties props = new PropertyManager().getProps();

    private TestUtils utils = new TestUtils();

    public BasePage() throws IOException {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(utils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));

    }

    public void clear(WebElement e, String msg) {
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
        switch (params.getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).activateApp(props.getProperty("androidAppPackage"));
                break;
            case "iOS":
                ((InteractsWithApps) driver).activateApp(props.getProperty("iOSBundleId"));
        }
    }

    public void closeApp() {
        switch (params.getPlatformName()) {
            case "Android":
                ((InteractsWithApps) driver).terminateApp(props.getProperty("androidAppPackage"));
                break;
            case "iOS":
                ((InteractsWithApps) driver).terminateApp(props.getProperty("iOSBundleId"));
        }
    }

    public WebElement scrollToElement() {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));"));
    }
/*
 @element - Scroll based on the paged you are currently viewing
 */
    public void scrollGesture(AppiumDriver driver, WebElement e) {
        waitForVisibility(e);
            driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) e).getId(),
                        "direction", "up",
                        "percent", 0.75
            ));
        utils.log().info("Swiping up");
        }

    }
