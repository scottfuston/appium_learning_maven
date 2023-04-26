package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.commands.ContactDetailCommands;
import io.cucumber.java.en.And;

import java.io.IOException;

public class ContactStepDef extends BasePage {
    ContactDetailCommands test = new ContactDetailCommands();

    public ContactStepDef() throws IOException {
    }

    @And("I click on contacts button")
    public void iClickContactsButton(){
        test.clickOnContactsButton();
    }
}
