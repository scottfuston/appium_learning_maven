package com.qa.commads;

import com.qa.pages.BasePage;
import com.qa.pages.LoginElements;
import com.qa.utils.GlobalParams;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import java.io.IOException;
import java.time.Duration;

public class LoginTests extends BasePage {
    LoginElements loginEl = new LoginElements();
    GlobalParams params = new GlobalParams();

    public LoginTests() throws IOException {
        super();
    }

    public void enterUserName(String username)
    {
        if(params.getPlatformName().equalsIgnoreCase("iOS"))
        {
            ((IOSDriver)driver).runAppInBackground((Duration.ofSeconds(3)));
        }

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
//        waitForVisibility(loginEl.feedGreeting);
//        click(loginEl.feedGreeting);
//        if(params.getPlatformName().equalsIgnoreCase("iOS")){
//            click(loginEl.gameCenterIcon);
//        }
        waitForVisibility(loginEl.homeTabBtn);
        Assert.assertTrue("Home Button is displayed", loginEl.homeTabBtn.isDisplayed());
    }

    public void callNumberIsDisplayed() {
        Assert.assertTrue("Call Support Number is displayed", loginEl.callNumberBtn.isDisplayed());
    }

    public void errorMessageIsDisplayed() {
        waitForVisibility(loginEl.emailErrorMessage);
        Assert.assertTrue("Email error message is displayed", loginEl.emailErrorMessage.isDisplayed());

    }

    public void gpLogoIsDisplayed() {
        waitForVisibility(loginEl.grandPadLogo);
        Assert.assertTrue("Grandpad Log is displayed", loginEl.grandPadLogo.isDisplayed());
    }

    public void clickOnProfileBtn()
    {
        if(params.getPlatformName().equalsIgnoreCase("IOS")){
            clickProfileIcon(driver);
        } else{
            waitForVisibility(loginEl.profileBtn);
            click(loginEl.profileBtn,"clicking profile user button");
        }
    }

    public void clickOnGearIcon()
    {
        waitForVisibility(loginEl.settingsGear);
        click(loginEl.settingsGear,"clicking setting gear icon");
    }

    public void clickOnLogOutBtn()
    {
        if(params.getPlatformName().equalsIgnoreCase("IOS"))
        {
            scrollGestureiOS(driver);
        } else {
            scrollGesture(driver, loginEl.notificationSettingsPage);
        }
        waitForVisibility(loginEl.logoutBtn);
        click(loginEl.logoutBtn, "clicking logout button");
    }

    public void logout()
    {
        waitForVisibility(loginEl.logoutDialog);
        sendKeys(loginEl.logOutDialogInput,"logout","typing logout");
        click(loginEl.confirmLogoutBtn,"Confirming - Clicking logout Button");
    }
}
