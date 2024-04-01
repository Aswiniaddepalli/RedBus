package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="features",
		glue="stepDefinitions",
		//plugin="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		plugin={"pretty","html:target/CucumberReports.html","json:target/CucumberReport/JSONReport.json"},
		dryRun=true)
public class RunnerClass extends AbstractTestNGCucumberTests{
	
 }