package com.qa.stepdef;

import com.qa.pages.BasePage;
import io.cucumber.java.Before;

import java.io.IOException;

/*
    Using Hooks in the Test runner
 */

public class Hooks {
    @Before
    public void initialize() throws IOException {
        BasePage basePage = new BasePage();
//        basePage.closeApp();
//        basePage.launchApp();
    }


}
