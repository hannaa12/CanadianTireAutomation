package com.fdmgroup.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.ItemPage;
import com.fdmgroup.pages.LoginPage;
import com.fdmgroup.pages.OutdoorLightingPage;
import com.fdmgroup.pages.WinterTiresPage;
import com.fdmgroup.utilities.DriverUtilities;
import com.fdmgroup.utilities.ExtentReportManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static ExtentTest test;
	static HomePage homePage;
	static ItemPage itemPage;
	static OutdoorLightingPage outdoorLightingPage;
	static WinterTiresPage winterTiresPage;
	static LoginPage loginPage;
	
	
	@Before
	public static void init(Scenario scenario) {
		
		// Setting up the driver
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		// Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360)); 

		
		
		// Page initialization
		homePage = new HomePage(driver);
		itemPage = new ItemPage(driver);
		outdoorLightingPage = new OutdoorLightingPage(driver);
		winterTiresPage = new WinterTiresPage(driver);
		loginPage = new LoginPage(driver);
		

		// Page maximize
		driver.manage().window().maximize();
		
		// Start Extent Report
        test = ExtentReportManager.createTest(scenario.getName());
        test.log(Status.INFO, "Starting Scenario: " + scenario.getName());
    }
 

    @After
    public static void tearDown(Scenario scenario) {
    	
    	// Capture screenshot for both passed and failed scenarios
        captureScreenshot(scenario.getName());
    	
        // Check scenario status
        if (scenario.getStatus().name().equalsIgnoreCase("FAILED")) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
        } 

        // Flush Extent Report
        ExtentReportManager.flushReport();

        // Reset Driver
        DriverUtilities.resetDriver();
    }
    
    public static void captureScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "src/test/resources/Screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileHandler.copy(srcFile, new File(filePath));
            test.log(Status.INFO, "Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
