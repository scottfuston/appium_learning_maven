package com.qa.stepdef;

import com.qa.commands.LoginCommands;
import com.qa.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class LoginStepDef extends BasePage{
    LoginCommands loginCommands = new LoginCommands();


    public LoginStepDef() throws IOException {
    }

    @And("I accept notifications")
    public void iAcceptNotifications() throws IOException {
        loginCommands.iAcceptNotifications();
    }

    @Then("call support number is displayed")
    public void callSupportNumberIsDisplayed() throws IOException {
        loginCommands.callNumberIsDisplayed();
    }

    @Then("I see an error message")
    public void i_see_an_error_message() throws IOException {
        loginCommands.errorMessageIsDisplayed();

    }

    @Then("Grandpad Logo is displayed")
    public void grandpadLogoIsDisplayed() throws IOException {
        loginCommands.gpLogoIsDisplayed();
    }

    @And("I click on the profile button")
    public void iClickOnTheProfileButton() throws IOException {
        loginCommands.clickOnProfileBtn();
    }

    @And("I click on the gear icon")
    public void iClickOnTheGearIcon() throws IOException {
        loginCommands.clickOnGearIcon();

    }

    @And("I click on log out button")
    public void iClickOnLogOutButton() throws IOException, InterruptedException {
        loginCommands.clickOnLogOutBtn();
    }

    @Then("I log out")
    public void iLogOut() throws IOException {
        loginCommands.logout();
    }
}


