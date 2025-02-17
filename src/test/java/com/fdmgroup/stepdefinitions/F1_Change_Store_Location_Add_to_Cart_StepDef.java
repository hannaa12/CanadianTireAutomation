package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.TimeoutException;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F1_Change_Store_Location_Add_to_Cart_StepDef {

	@Given("the user navigates to the item page")
	public void the_item_page_is_displayed() {

			Hooks.driver.navigate().to(DataFile.StringLightsURL);
	}

	
	@When("the user selects {string} and clicks on Check other stores")
	public void the_user_selects_and_clicks_on_check_other_stores(String deliveryOption) {
		Hooks.itemPage.selectDeliveryOption(deliveryOption);
		Hooks.itemPage.clickOnStoreOptionsBtn();
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String pickUpLocation) {
		Hooks.itemPage.choosePickUpLocation(pickUpLocation);
	}

	@Then("the user confirms the store selection")
	public void the_user_confirms_the_store_selection_by_verifying_the_pop_up() {
		assertTrue(Hooks.itemPage.isPickUpLocationVerified());
	}

	@Then("the user clicks on the Add to Cart button")
	public void the_user_clicks_on_the_add_to_cart_button() {
		Hooks.itemPage.clickOnAddToCart();
	}
	
}
