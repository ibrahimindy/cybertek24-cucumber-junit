package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "rerun:target/rerun.txt",//store failed scenario names into rerun.txt file
                 "json:target/cucumber.json"
        },
      features ="src/test/resources/features" ,
        glue = "com/cydeo/step_definitions",
        dryRun = false
        //tags = "@lyft"

)
public class CukesRunner {


}
