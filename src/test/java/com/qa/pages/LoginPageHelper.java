package com.qa.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends BasePage{
    public LoginPageHelper(){
        super();
    }
    @AndroidFindBy(id = "net.grandpad.puma:id/tiEmailEditText")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Email\"")
    public WebElement emailInput;
    @AndroidFindBy(id = "net.grandpad.puma:id/tvButtonText")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue\" AND name == \"Continue\" AND value == \"Continue\"")
    public WebElement continueBtn;

    @AndroidFindBy (id = "net.grandpad.puma:id/tvPassword")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"I'd rather type my password\" AND name == \"I'd rather type my password\" AND value == \"I'd rather type my password\"")
    public WebElement typeMyPassBtn;

    @AndroidFindBy (id = "net.grandpad.puma:id/tiPasswordEditText")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Password\"")
    public WebElement passInputField;

    @AndroidFindBy (id = "net.grandpad.puma:id/tvButtonText")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue\" AND name == \"Continue\" AND value == \"Continue\"")
    public WebElement logInSubmitBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Horizontal scroll bar, 1 page\"`][2]")
    public WebElement allowNotificationBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    @iOSXCUITFindBy(accessibility = "Don’t Allow")
    public WebElement dontAllowNotificationBtn;

    @AndroidFindBy(id ="net.grandpad.puma:id/navigation_bar_item_large_label_view")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"tab_home\"")
    public WebElement homeTabBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Call Support (800) 704-9412\"`]")
    @AndroidFindBy(id = "net.grandpad.puma:id/tvInfoSupport")
    public WebElement callNumberBtn;

    @AndroidFindBy( id = "net.grandpad.puma:id/ivLogo")
    @iOSXCUITFindBy(accessibility = "logo_2020")
    public WebElement grandPadLogo;

    @AndroidFindBy(id ="net.grandpad.puma:id/btnOpenEmail")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Open Email\" AND name == \"Open Email\" AND type == \"XCUIElementTypeButton\"")
    public WebElement openEmailBtn;

    @AndroidFindBy(id ="net.grandpad.puma:id/ivGameCenter")
    @iOSXCUITFindBy(accessibility = "games icon")
    public WebElement gameCenterIcon;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvFeedGreetingName")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Hi James,\" AND name == \"Hi James,\" AND value == \"Hi James,\"")
    public WebElement faUserName;

    @AndroidFindBy (id="android:id/alertTitle")
    public WebElement supportNumberAlertTitle;

    @AndroidFindBy (id="android:id/button2")
    public WebElement supportNumberAlertCancelBtn;

    @AndroidFindBy (id="android:id/button1")
    public WebElement supportNumberAlertCallBtn;

    @AndroidFindBy (id = "net.grandpad.puma:id/snackbar_text")
    @iOSXCUITFindBy(accessibility = "Invalid Email")
    public WebElement emailErrorMessage;

    @AndroidFindBy(id = "net.grandpad.puma:id/clFeedGreeting")
    public WebElement feedGreeting;

    @AndroidFindBy(id = "net.grandpad.puma:id/ivFeedProfile")
    public WebElement profileBtn;

    @AndroidFindBy(accessibility = "Settings")
    public WebElement settingsGear;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvSettingsLogOut")
    public WebElement logoutBtn;

    @AndroidFindBy(id = "net.grandpad.puma:id/etLogoutDialog")
    public WebElement logOutDialogBtn;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement confirmLogoutBtn;

    public void enterUserName(String username)
    {
        waitForVisibility(emailInput);
        clear(emailInput,"Clearing email input field");
        sendKeys(emailInput,username,"Email user : " + username);
        click(continueBtn,"Clicking Continue Button");

    }
    public void enterPassword(String password)
    {
        waitForVisibility(typeMyPassBtn);
        click(typeMyPassBtn,"Clicking Type my Password Button");
        sendKeys(passInputField,password,"Typing password " + password);
    }
    public void login()
    {
        waitForVisibility(logInSubmitBtn);
        click(logInSubmitBtn,"Clicking LogIn Submit Button");

    }

    public void iAcceptNotifications() {
        waitForVisibility(allowNotificationBtn);
        click(allowNotificationBtn,"Clicking allow notifications");
    }

    public void iamLoggedIn()
    {
        waitForVisibility(feedGreeting);
        click(feedGreeting);
        waitForVisibility(homeTabBtn);
        Assert.assertEquals("Home Button is displayed",true,homeTabBtn.isDisplayed());
    }

    public void callNumberIsDisplayed() {
        Assert.assertEquals("Call Support Number is displayed",true,callNumberBtn.isDisplayed());
    }

    public void errorMessageIsDisplayed() {
        waitForVisibility(emailErrorMessage);
        Assert.assertEquals("Email error message is displayed",true,emailErrorMessage.isDisplayed());
    }

    public void gpLogoIsDisplayed() {
        waitForVisibility(grandPadLogo);
        Assert.assertEquals("Grandpad Log is displayed",true,grandPadLogo.isDisplayed());
    }

    public void clickOnProfileBtn()
    {
        waitForVisibility(profileBtn);
        click(profileBtn,"clicking profile user button");
    }

    public void clickOnGearIcon()
    {
        waitForVisibility(settingsGear);
        click(settingsGear,"clicking setting gear icon");
    }

    public void clickOnLogOutBtn()
    {
        waitForVisibility(logoutBtn);
        click(logoutBtn,"clicking logout button");
    }

    public void logout()
    {
        waitForVisibility(logOutDialogBtn);
        sendKeys(logoutBtn,"logout","typing logout");
        click(logInSubmitBtn,"Confirming - Clicking logout Button");
    }
}
