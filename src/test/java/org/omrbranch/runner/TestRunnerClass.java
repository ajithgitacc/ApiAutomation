package org.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login or @State or @City or @Address or @Product or @Profilepic",plugin = {"pretty","json:target\\output.json"},dryRun = false,glue="org.omrbranch.stepdefinition",features ="src\\test\\resources\\Feature")
public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(getProjectPath() +getPropertyFileValue("jsonPath"));
	}
}
 