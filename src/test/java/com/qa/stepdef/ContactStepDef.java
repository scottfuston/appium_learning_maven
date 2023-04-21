package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.tests.ContactDetailTests;
import io.cucumber.java.en.And;

import java.io.IOException;

public class ContactStepDef extends BasePage {
    ContactDetailTests test = new ContactDetailTests();
    public ContactStepDef() throws IOException {
    }

    @And("I click on contacts button")
    public void iClickContactsButton(){
        test.clickOnContactsButton();
    }
}
