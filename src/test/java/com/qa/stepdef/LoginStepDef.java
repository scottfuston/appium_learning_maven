package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.pages.LoginPageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginStepDef extends BasePage {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        new LoginPageHelper().enterUserName(username);
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPageHelper().enterPassword(password);
    }

    @When("I enter submit button")
    public void iLogin() {
       new LoginPageHelper().login();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        new LoginPageHelper().iamLoggedIn();
    }

    @And("I accept notifications")
    public void iAcceptNotifications() {
        new LoginPageHelper().iAcceptNotifications();
    }

    @Then("call support number is displayed")
    public void callSupportNumberIsDisplayed() {
        new LoginPageHelper().callNumberIsDisplayed();
    }
}


