package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginElements extends BasePage {
    public LoginElements() throws IOException {
    }
    @AndroidFindBy(id = "net.grandpad.puma:id/tiEmailEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"GrandPad\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
//    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Email\"")
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
    @iOSXCUITFindBy(accessibility = "tab_home")
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
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Hi James,\"")
    public WebElement feedGreeting;

    @AndroidFindBy(id = "net.grandpad.puma:id/ivFeedProfile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Serval.FeedTableView\"`]/XCUIElementTypeButton[4]")
    public WebElement profileBtn;

    @AndroidFindBy(accessibility = "Settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Serval.ProfileTableView\"`]/XCUIElementTypeButton[3]")
    public WebElement settingsGear;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvSettingsLogOut")
    @iOSXCUITFindBy(accessibility = "Logout")
    public WebElement logoutBtn;

    @AndroidFindBy(id = "net.grandpad.puma:id/parentPanel")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeAlert[`label == \"Logout\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]")
    public WebElement logoutDialog;
    @AndroidFindBy(id = "net.grandpad.puma:id/etLogoutDialog")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    public WebElement logOutDialogInput;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "LOGOUT")
    public WebElement confirmLogoutBtn;

    @AndroidFindBy(id="net.grandpad.puma:id/tvSettingsNotificationsHeader")
    public WebElement notificationSetting;

    @AndroidFindBy(id="android:id/content")
    public WebElement notificationSettingsPage;
}
