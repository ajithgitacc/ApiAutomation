package org.omrbranch.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 

import org.omrbranch.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class Reporting extends BaseClass {
	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		File reportdirectory= new File(getProjectPath() +getPropertyFileValue("jvmPath"));
		Configuration configuration= new Configuration(reportdirectory, "OMRBranchAPIAutomation");
		configuration.addClassifications("platformName", "windows");
		configuration.addClassifications("platformVersion", "10");
		configuration.addClassifications("author", "ajith");
		configuration.addClassifications("environment", "QA");
		configuration.addClassifications("sprintNumber", "34");
		List<String> jsonFiles= new ArrayList<>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder= new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
}

}
