package cydeo.runners;

import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
        "json:target/cucumber.json",
        //"pretty",
        //"html:target/cucumber-reports.html",
        //"rerun:target/rerun.txt",
        //"me.jvt.cucumber.report.PrettyReports:target/cucumber",
    },
        features = "src/test/resources/features",
        glue = "cydeo/step_definitions",
        dryRun = false,
        tags = " @UPGNX10-322",
        publish = false

)
public class CukesRunner {
}


