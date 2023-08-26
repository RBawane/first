package Cucumber;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/java/cucumber", glue="FirstProject.stepDefinations",
monochrome=true, plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner {

}
