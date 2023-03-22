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
    public WebElement grandPadLogo;

    @AndroidFindBy(id ="net.grandpad.puma:id/btnOpenEmail")
    public WebElement openEmailBtn;

    @AndroidFindBy(id ="net.grandpad.puma:id/ivGameCenter")
    public WebElement gameCenterIcon;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvFeedGreetingName")
    public WebElement faUserName;

    public void enterUserName(String username)
    {

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
        waitForVisibility(homeTabBtn);
        Assert.assertEquals("Home Button is displayed",true,homeTabBtn.isDisplayed());
    }

    public void callNumberIsDisplayed() {
        Assert.assertEquals("Call Support Number is displayed",true,callNumberBtn.isDisplayed());
    }
}
