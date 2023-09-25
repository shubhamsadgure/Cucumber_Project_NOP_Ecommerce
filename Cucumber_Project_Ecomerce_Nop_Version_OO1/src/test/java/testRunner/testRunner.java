package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={".//Features/Customer.feature",".//Features/Login.feature"},
glue={"stepDefinitions"},
dryRun=false,
plugin={"pretty","html:target/reports/HtmlReports","json:target/reports/cucumber.json","junit:target/reports/cucumber.xml"},
monochrome=true,
tags="@datadriven or  @sanity"
)

public class testRunner {

}
