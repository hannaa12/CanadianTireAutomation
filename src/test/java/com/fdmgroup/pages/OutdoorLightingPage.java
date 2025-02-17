package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutdoorLightingPage {
	
	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public OutdoorLightingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='nl-categoryMasthead-banner__title']")
	WebElement stringLightsHeading;
	
	@FindBy(xpath = "//li[@id='0528035P']")
	WebElement item;

	public boolean isStringLightsPageDisplayed() {
		return stringLightsHeading.isDisplayed();
	}

	public void clicksOnTheStringLightsItem() {
		item.click();
	}
}
