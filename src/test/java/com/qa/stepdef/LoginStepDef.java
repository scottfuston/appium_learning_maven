package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.tests.LoginTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginStepDef extends BasePage{
    LoginTests test = new LoginTests();
    public LoginStepDef() throws IOException {
    }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws IOException {
        test.enterUserName(username);
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) throws IOException {
        test.enterPassword(password);
    }

    @When("I enter submit button")
    public void iLogin() throws IOException {
       test.login();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws IOException {
       test.iamLoggedIn();
    }

    @And("I accept notifications")
    public void iAcceptNotifications() throws IOException {
        test.iAcceptNotifications();
    }

    @Then("call support number is displayed")
    public void callSupportNumberIsDisplayed() throws IOException {
        test.callNumberIsDisplayed();
    }

    @Then("I see an error message")
    public void i_see_an_error_message() throws IOException {
        test.errorMessageIsDisplayed();

    }

    @Then("Grandpad Logo is displayed")
    public void grandpadLogoIsDisplayed() throws IOException {
        test.gpLogoIsDisplayed();
    }

    @And("I click on the profile button")
    public void iClickOnTheProfileButton() throws IOException {
        test.clickOnProfileBtn();
    }

    @And("I click on the gear icon")
    public void iClickOnTheGearIcon() throws IOException {
        test.clickOnGearIcon();

    }

    @And("I click on log out button")
    public void iClickOnLogOutButton() throws IOException, InterruptedException {
        test.clickOnLogOutBtn();
    }

    @Then("I log out")
    public void iLogOut() throws IOException {
        test.logout();
    }
}


