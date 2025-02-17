package com.fdmgroup.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.fdmgroup.stepdefinitions",
		plugin = {
				"pretty",
				"json:Report/cucumber.json",
				"junit:Report/cucumber.junit",
				"html:Report/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		monochrome = false,
		dryRun = false,
		publish = true
		,tags = "@login"
		)
public class Runner {

}
