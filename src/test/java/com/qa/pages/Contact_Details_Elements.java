package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;



public class Contact_Details_Elements {

    public Contact_Details_Elements() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Contacts\"]/android.widget.ImageView")
    public WebElement contactsBtn;
    @AndroidFindBy( xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup")
    public WebElement contact;
}
