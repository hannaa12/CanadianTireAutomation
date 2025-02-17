package com.fdmgroup.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {

	private static DriverUtilities driverUtilities;

	private WebDriver driver;

	private DriverUtilities() {
		super();
	}

	public static DriverUtilities getInstance() {
		if (driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}
		return driverUtilities;
	}
	
	public static void resetDriver() {
		driverUtilities.driver.quit();
		driverUtilities.driver = null;
		driverUtilities = null;
	}

	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private void createDriver() {
		String driverName = getDriverName();

		switch (driverName) {
		case "Chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(); 
			break;

		case "Firefox":
			driver = new FirefoxDriver();
		default:
			break;
		}
	}

	private String getDriverName() {
		Properties config = new Properties();

		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return config.getProperty("browser");
	}
}
