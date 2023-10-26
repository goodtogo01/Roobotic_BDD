package com.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\zaman\\eclipse-workspace\\RoboticBDD\\src\\main\\java\\com\\Features\\Login.feature", //path of feature file
		glue = {"com.StepDefinitions"}, // Step def file path
		plugin = {"pretty", "html:OutPut_Result", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},// To generate HTML Report
		dryRun = true, // to find the un-defined steps from the feature file and thes will not execute untill status is "true" 
		monochrome = false, //, // Console output testcase design
		strict = true // Test will be execute, but if there any undefined step/s left, it will throw exceptions as "PandingExceptions"
		
		)

public class TestRunner {

}
//