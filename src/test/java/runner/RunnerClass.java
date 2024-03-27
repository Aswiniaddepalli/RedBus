package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="features",
		glue="stepDefinitions")
public class RunnerClass extends AbstractTestNGCucumberTests{ 
}
