package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class ContactDetailsElements extends BasePage {
    public ContactDetailsElements() throws IOException {
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Contacts\"]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Contacts")
    public WebElement contactsBtn;

    @AndroidFindBy( xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement contact;

    @AndroidFindBy(id = "net.grandpad.puma:id/ivProfileImage")
    public WebElement contactProfileImage;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvProfileName")
    public WebElement contactProfileName;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvProfileWeatherLocation")
    public WebElement contactProfileWeatherLocation;

    @AndroidFindBy(id = "net.grandpad.puma:id/tvProfileLocalTime")
    public WebElement contactProfileLocalTime;

    @AndroidFindBy(id = "net.grandpad.puma:id/llProfileVoiceCall")
    @iOSXCUITFindBy(accessibility = "voiceCallButton")
    public WebElement contactProfileVoiceCall;

    @AndroidFindBy(id = "net.grandpad.puma:id/llProfileVideoCall")
    @iOSXCUITFindBy(accessibility ="videochatButton")
    public WebElement contactProfileVideoCall;

    @AndroidFindBy(id = "net.grandpad.puma:id/llProfileEmail")
    @iOSXCUITFindBy(accessibility = "emailButton")
    public WebElement contactProfileEmail;

    @AndroidFindBy(id = "net.grandpad.puma:id/llProfileTextMessage")
    @iOSXCUITFindBy(accessibility = "textMessageButton")
    public WebElement contactProfileTextMessage;

    @AndroidFindBy(accessibility = "More options")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Serval.ContactDetailTableView\"`]/XCUIElementTypeButton[2]")
    public WebElement threeDots;

    @AndroidFindBy(id = "net.grandpad.puma:id/title")
    public WebElement removeContact;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup")
    public WebElement contactPost;
}
