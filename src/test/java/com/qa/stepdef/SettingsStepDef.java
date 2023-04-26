package com.qa.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDef {
    public SettingsStepDef() {}

    @Given("I am logged in")
    public void amLoggedIn(){}

    @When("I click the profile icon")
    public void clickProfileIcon(){}

    @And("I click the settings icon")
    public void clickSettingsIcon(){}

    @Then("I should be on the settings page")
    public void shouldBeOnSettingsPage(){}
}
