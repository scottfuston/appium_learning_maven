package com.qa.commads;

import com.qa.pages.BasePage;
import com.qa.pages.ContactDetailsElements;

import java.io.IOException;

public class ContactDetailTests extends BasePage {
    ContactDetailsElements el = new ContactDetailsElements();

    public ContactDetailTests() throws IOException {
    }

    public void clickOnContactsButton()
    {
        waitForVisibility(el.contactsBtn);
        click(el.contactsBtn,"Tapping Contact button");
    }
}
