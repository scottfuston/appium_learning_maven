package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.tests.LoginTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginStepDef extends BasePage {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        new LoginTests().enterUserName(username);
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginTests().enterPassword(password);
    }

    @When("I enter submit button")
    public void iLogin() {
       new LoginTests().login();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        new LoginTests().iamLoggedIn();
    }

    @And("I accept notifications")
    public void iAcceptNotifications() {
        new LoginTests().iAcceptNotifications();
    }

    @Then("call support number is displayed")
    public void callSupportNumberIsDisplayed() {
        new LoginTests().callNumberIsDisplayed();
    }

    @Then("I see an error message")
    public void i_see_an_error_message() {
        new LoginTests().errorMessageIsDisplayed();

    }

    @Then("Grandpad Logo is displayed")
    public void grandpadLogoIsDisplayed() {
        new LoginTests().gpLogoIsDisplayed();
    }

    @And("I click on the profile button")
    public void iClickOnTheProfileButton() {
        new LoginTests().clickOnProfileBtn();
    }

    @And("I click on the gear icon")
    public void iClickOnTheGearIcon() {
        new LoginTests().clickOnGearIcon();

    }

    @And("I click on log out button")
    public void iClickOnLogOutButton() {
        new LoginTests().clickOnLogOutBtn();
    }

    @Then("I log out")
    public void iLogOut() {
        new LoginTests().logout();
    }
}


