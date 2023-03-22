package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParamsSauce;
import com.qa.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber"
                , "summary"
        }
        ,features = {"src/test/resources"}
        ,glue = {"com.qa.stepdef"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true

)

public class MyRunnerTest {


        @BeforeClass
        public static void initialize() throws Exception {
                /*
                Local Development
                 */
//                GlobalParams params = new GlobalParams();
//                params.initializeGlobalParams();

                /*
                Sauce Labs
                 */
                GlobalParamsSauce params = new GlobalParamsSauce();
                params.initializeGlobalParams();

                ThreadContext.put("ROUTINGKEY",params.getPlatformName() + "_"
                + params.getDeviceName());

                new ServerManager().startServer();
                new DriverManager().initializeDriver();
        }
        @AfterClass
        public static void quit(){
                DriverManager driverManager = new DriverManager();
                if(driverManager.getDriver() != null){
                        driverManager.getDriver().quit();
                        driverManager.setDriver(null);
                }
                ServerManager serverManager = new ServerManager();
                if(serverManager.getServer() != null){
                        serverManager.getServer().stop();
                }
        }



}
