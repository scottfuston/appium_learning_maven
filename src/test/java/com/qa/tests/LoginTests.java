package com.qa.tests;
import com.qa.pages.BasePage;
import com.qa.pages.LoginElements;
import org.junit.Assert;

public class LoginTests extends BasePage {
    LoginElements loginEl = new LoginElements();
    public LoginTests(){
        super();
    }

    public void enterUserName(String username)
    {
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
        waitForVisibility(loginEl.logoutBtn);
        click(loginEl.logoutBtn,"clicking logout button");
    }

    public void logout()
    {
        waitForVisibility(loginEl.logOutDialogBtn);
        sendKeys(loginEl.logoutBtn,"logout","typing logout");
        click(loginEl.logInSubmitBtn,"Confirming - Clicking logout Button");
    }
}
