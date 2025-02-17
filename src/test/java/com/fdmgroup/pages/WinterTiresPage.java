package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.stepdefinitions.Hooks;

public class WinterTiresPage {

	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public WinterTiresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form//ancestor::div//button[contains(@class, 'nl-dropdown__button nl-dropdown__button--sort-button')]")
	WebElement vehicleTypeDropdown;

	@FindBy(xpath = "//form/descendant::button[contains(text(), 'Add Vehicle')]")
	WebElement getAddVehicle;

	@FindBy(xpath = "//form/descendant::button[contains(@aria-label, 'Year')]")
	WebElement yearDropdown;

	@FindBy(xpath = "//form/descendant::button[contains(@aria-label, 'Make')]")
	WebElement makeDropdown;

	@FindBy(xpath = "//div[contains(@class, 'nl-vehicle-banner__details__header__sub-title')]")
	WebElement successMsg;

	public WebElement getVehicleTypeDropdown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", vehicleTypeDropdown);
		return vehicleTypeDropdown;
	}

	public WebElement getAddVehicle() {
		return getAddVehicle;
	}

	public WebElement getYearDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(yearDropdown));
		return yearDropdown;
	}

	public WebElement getMakeDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(makeDropdown));
		return makeDropdown;
	}

	public boolean getSuccesMsg() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", successMsg);
		return successMsg.isDisplayed();
	}
}
