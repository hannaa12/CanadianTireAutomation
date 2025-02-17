package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='nl-product__title']")
	WebElement stringLightsItemName;

	@FindBy(xpath = "//div/following-sibling::button[@id='pick-up-check-other-store']")
	WebElement checkOtherStoreOption;
	
	@FindBy(xpath = "//div[@class='nl-buy-online__free-pickup-container--pickup-label']/following-sibling::div")
	WebElement isPickUpLocationSuccessMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'product-details')]//ancestor::div//button[@data-testid='add-to-cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//h2[contains(text(), 'Item Added to Cart')]")  
	WebElement itemAddedToCartMessage;

	


	public boolean isItemPageDisplayed() {
		return stringLightsItemName.isDisplayed();
	}

	public void selectDeliveryOption(String deliveryOption) {
		WebElement deliveryElement = driver.findElement(
				By.xpath("//div[@class='nl-buy-online__box']//span[contains(text(), '" + deliveryOption + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", deliveryElement);
		deliveryElement.click();
	}

	public void clickOnStoreOptionsBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", checkOtherStoreOption);
		checkOtherStoreOption.click();
	}

	public void choosePickUpLocation(String pickUpLocation) {
	    String xpath = "//h3[text()='" + pickUpLocation + "']/ancestor::li//button[contains(text(),'Select this store')]";
	    WebElement selectStoreButton = driver.findElement(By.xpath(xpath));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", selectStoreButton);
	    selectStoreButton.click();
	}

	public boolean isPickUpLocationVerified() {
		return isPickUpLocationSuccessMsg.isDisplayed();
	}

	public void clickOnAddToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		addToCartButton.click();
	}

	public String isSuccessMsgDisplayedForCart() {
		return itemAddedToCartMessage.getText();
	}

}
