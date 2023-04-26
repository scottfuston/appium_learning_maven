package com.qa.stepdef;

import com.qa.commands.LoginCommands;
import com.qa.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CommonStepDef extends BasePage {
    public CommonStepDef() throws IOException {
        super();
    }

    // LOGIN
    LoginCommands loginCommands = new LoginCommands();

    @When("I enter email as {string}")
    public void iEnterEmailAs(String email) throws IOException, InterruptedException {
        loginCommands.enterEmail(email);
    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password) throws IOException {
        loginCommands.enterPassword(password);
    }

    @When("I enter submit button")
    public void iLogin() throws IOException {
        loginCommands.login();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws IOException {
        loginCommands.iamLoggedIn();
    }

    @Given("I am logged in as {string}")
    public void loggedInAs(String email){
        loginCommands.enterEmail(email); // TODO: Read user data from file
        loginCommands.enterPassword("Test12345!"); // TODO: Store static user data in a file
        loginCommands.login();
        loginCommands.iamLoggedIn();
    }
}
