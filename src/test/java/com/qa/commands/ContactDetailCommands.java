package com.qa.commands;

import com.qa.pages.BasePage;
import com.qa.pages.ContactDetailsElements;

import java.io.IOException;

public class ContactDetailCommands extends BasePage {
    ContactDetailsElements el = new ContactDetailsElements();

    public ContactDetailCommands() throws IOException {
        super();
    }

    public void clickOnContactsButton()
    {
        waitForVisibility(el.contactsBtn);
        click(el.contactsBtn,"Tapping Contact button");
    }
}
