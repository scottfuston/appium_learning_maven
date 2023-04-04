package com.qa.tests;

import com.qa.pages.BasePage;
import com.qa.pages.LoginElements;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

public class LoginTests extends BasePage {
    LoginElements loginEl = new LoginElements();
    TestUtils utils = new TestUtils();
    public LoginTests() throws IOException {
        super();
    }

    public void enterUserName(String username) throws InterruptedException {
        waitForVisibility(loginEl.emailInput);
        clear(loginEl.emailInput,"Clearing email input field");
        sendKeys(loginEl.emailInput,username,"Email user : " + username);
        click(loginEl.continueBtn,"Clicking Continue Button");

    }
    public void enterPassword(String password)
    {
        waitForVisibility(loginEl.typeMyPassBtn);
        click(loginEl.typeMyPassBtn,"Clicking Type my Password Button");
        sendKeys(loginEl.passInputField,password,"Typing password " + password);
    }
    public void login()
    {
        waitForVisibility(loginEl.logInSubmitBtn);
        click(loginEl.logInSubmitBtn,"Clicking LogIn Submit Button");

    }

    public void iAcceptNotifications() {
        waitForVisibility(loginEl.allowNotificationBtn);
        click(loginEl.allowNotificationBtn,"Clicking allow notifications");
    }

    public void iamLoggedIn()
    {
        waitForVisibility(loginEl.feedGreeting);
        click(loginEl.feedGreeting);
        waitForVisibility(loginEl.homeTabBtn);
        Assert.assertEquals("Home Button is displayed",true,loginEl.homeTabBtn.isDisplayed());
    }

    public void callNumberIsDisplayed() {
        Assert.assertEquals("Call Support Number is displayed",true,loginEl.callNumberBtn.isDisplayed());
    }

    public void errorMessageIsDisplayed() {
        waitForVisibility(loginEl.emailErrorMessage);
        Assert.assertEquals("Email error message is displayed",true,loginEl.emailErrorMessage.isDisplayed());

    }

    public void gpLogoIsDisplayed() {
        waitForVisibility(loginEl.grandPadLogo);
        Assert.assertEquals("Grandpad Log is displayed",true,loginEl.grandPadLogo.isDisplayed());
    }

    public void clickOnProfileBtn()
    {
        waitForVisibility(loginEl.profileBtn);
        click(loginEl.profileBtn,"clicking profile user button");
    }

    public void clickOnGearIcon()
    {
        waitForVisibility(loginEl.settingsGear);
        click(loginEl.settingsGear,"clicking setting gear icon");
    }

    public void clickOnLogOutBtn()
    {
            scrollGesture(driver,loginEl.notificationSettingsPage);
            waitForVisibility(loginEl.logoutBtn);
            click(loginEl.logoutBtn,"clicking logout button");
    }

    public void logout()
    {
        waitForVisibility(loginEl.logoutDialog);
        sendKeys(loginEl.logOutDialogInput,"logout","typing logout");
        click(loginEl.confirmLogoutBtn,"Confirming - Clicking logout Button");
    }
}
