package com.qa.stepdef;

import com.qa.pages.BasePage;
import io.cucumber.java.Before;

/*
    Using Hooks in the Test runner

 */
public class Hooks {
    @Before
    public void initialize() {
        BasePage basePage = new BasePage();
//        basePage.closeApp();
//        basePage.launchApp();
    }


}
