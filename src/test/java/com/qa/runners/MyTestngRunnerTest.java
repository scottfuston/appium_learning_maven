package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/"
                , "summary"
        },
        features = {"src/test/java/com/qa/features"},
        glue = {"com.qa.stepdef"},
        dryRun=false,
        monochrome=true
)
public class MyTestngRunnerTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({
            "platformName",
            "udid",
            "deviceName",
            "systemPort",
            "chromeDriverPort",
            "wdaLocalPort",
            "webkitDebugProxyPort",
            "avd",
            "automationName",
            "appLocation",
            "platformVersion"})

    @BeforeClass(alwaysRun = true)
    public void setUpClass(
            String platformName,
            @Optional() String udid,
            String deviceName,
            @Optional() String systemPort,
            @Optional() String chromeDriverPort,
            @Optional() String wdaLocalPort,
            @Optional() String webkitDebugProxyPort,
            @Optional() String avd,
            String automationName,
            String appLocation,
            @Optional() String platformVersion
    ) throws Exception {
        TestUtils utils = new TestUtils();
        utils.log().info("setUpClass running.");
        //log4j logging
        ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);

        GlobalParams params = new GlobalParams();
        params.setPlatformName(platformName);
        params.setUDID(udid);
        params.setDeviceName(deviceName);
        params.setAutomationName(automationName);
        params.setAppLocation(appLocation);
        params.setPlatformVersion(platformVersion);

        switch (platformName) {
            case "Android" -> {
                params.setSystemPort(systemPort);
                params.setChromeDriverPort(chromeDriverPort);
                params.setAvd(avd);
            }
            case "iOS" -> {
                params.setWdaLocalPort(wdaLocalPort);
                params.setWebkitDebugProxyPort(webkitDebugProxyPort);
            }
        }

        new ServerManager().startServer();
        new DriverManager().initializeDriver();

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")

    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws IOException {
        DriverManager driverManager = new DriverManager();

        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }

        if(testNGCucumberRunner != null){
            testNGCucumberRunner.finish();
        }
    }

}