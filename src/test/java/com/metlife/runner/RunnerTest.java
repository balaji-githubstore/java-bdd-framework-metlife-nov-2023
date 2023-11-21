package com.metlife.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        features = {"src/test/resources/features/Login.feature","src/test/resources/features/Patient.feature"}
        features = {"src/test/resources/features"}
        ,glue = {"com.metlife.steps","com.metlife.base"}
      //  ,dryRun = true
        ,publish = false
        ,plugin = {"html:target/cucumber-report.html"}
        ,tags="@patient"
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
