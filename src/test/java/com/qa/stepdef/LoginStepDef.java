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

    @Then("I see an error message")
    public void i_see_an_error_message() {
        new LoginPageHelper().errorMessageIsDisplayed();

    }

    @Then("Grandpad Logo is displayed")
    public void grandpadLogoIsDisplayed() {
        new LoginPageHelper().gpLogoIsDisplayed();
    }

    @And("I click on the profile button")
    public void iClickOnTheProfileButton() {
        new LoginPageHelper().clickOnProfileBtn();
    }

    @And("I click on the gear icon")
    public void iClickOnTheGearIcon() {
        new LoginPageHelper().clickOnGearIcon();

    }

    @And("I click on log out button")
    public void iClickOnLogOutButton() {
        new LoginPageHelper().clickOnLogOutBtn();
    }

    @Then("I log out")
    public void iLogOut() {
        new LoginPageHelper().logout();
    }
}


