package com.qa.tests;

import com.qa.pages.BasePage;
import com.qa.pages.Contact_Details_Elements;

import java.io.IOException;

public class ContactDetailTests extends BasePage {
    Contact_Details_Elements el = new Contact_Details_Elements();

    public ContactDetailTests() throws IOException {
    }

    public void clickOnContactsButton()
    {
        waitForVisibility(el.contactsBtn);
        click(el.contactsBtn,"Tapping Contact button");
    }
}
