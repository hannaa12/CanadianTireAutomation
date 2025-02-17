package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;


	// Constructor to initialize the WebDriver and WebElements
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement acceptAllButton;

	@FindBy(xpath = "//button[@class='CTR_loyalty-offer-close-button' and @aria-label='Close Button']")
	WebElement continueBtn;

	@FindBy(xpath = "//button[@data-testid='secondary-navigation-link-0']")
	WebElement shopByDepartmentMenu;

	@FindBy(xpath = "//button[text()='Outdoor Living']")
	WebElement outdoorLivingOption;

	@FindBy(xpath = "//li/button[@data-testid='mega-navigation-list-item--10' and normalize-space()='Outdoor Lighting']")
	WebElement outdoorLightingOption;

	@FindBy(xpath = "//nav/ul/li[1]/div/div/ul/li[3]/div/ul/li[11]/div/ul/li[13]/a")
	WebElement stringLightsOption;

	public void handlePopUps() {
		acceptAllButton.click();
	}

	public void handleOfferBanner() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
	}

	public void clickOnShopByDepartment() {
		shopByDepartmentMenu.click();
	}

	public void clickOnOutdoorLiving() {
		outdoorLivingOption.click();
	}

	public void clickOnOutdoorLighting() {
		outdoorLightingOption.click();
	}

	public void clickOnStringLights() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", stringLightsOption);
		stringLightsOption.click();
	}


}
