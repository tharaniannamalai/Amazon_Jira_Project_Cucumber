package com.cucumber.runner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.utilityFiles.Utility_Files;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".//FeatureFiles//Amazon.feature",
		
		glue = "com.stepdef.amazon",
		
		monochrome = true,
		
		dryRun = false,
		
		publish = true,
		
		plugin = {"html:TestReport/report.html", "json:TestReport/jsReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@FashionLink"
		
		)
public class Cucumber_Amazon_Runner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp()
	{	
		driver = Utility_Files.browser_Config("chrome");
		
		Utility_Files.implicit_Wait("seconds", 900);
	}

	@AfterClass
	public static void tearDown()
	{
		driver.close();
	}
}