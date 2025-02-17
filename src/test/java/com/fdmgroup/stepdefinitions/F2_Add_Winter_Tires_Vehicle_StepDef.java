package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F2_Add_Winter_Tires_Vehicle_StepDef {

	Actions action = new Actions(Hooks.driver);

	@Given("the user is on the Add New Vehicle page")
	public void the_user_is_on_the_add_new_vehicle_page() {

			Hooks.driver.navigate().to(DataFile.WinterTiresURL);
	}

	@When("the user selects ATV & UTV as Vehicle Type")
	public void the_user_selects_atv_utv_as_vehicle_type() {

			action.moveToElement(Hooks.winterTiresPage.getVehicleTypeDropdown()).click().perform();
			action.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_UP).pause(500).sendKeys(Keys.ENTER)
					.perform();
	}

	@When("the user selects {int} as Year")
	public void the_user_selects_as_year(Integer int1) {
			action.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ENTER)
					.perform();
	}

	@When("the user selects Arctic Cat as Make")
	public void the_user_selects_arctic_cat_as_make() {
		action.moveToElement(Hooks.winterTiresPage.getMakeDropdown()).click().perform();
		action.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_DOWN)
				.pause(500).sendKeys(Keys.ENTER).perform();
	}

	@When("the user selects Alterra 300 as Model")
	public void the_user_selects_alterra_300_as_model() {
		action.sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_DOWN).pause(500).sendKeys(Keys.ARROW_DOWN)
				.pause(500).sendKeys(Keys.ENTER).perform();
	}
	
	@When("the user clicks on Add Vehicle")
	public void the_user_clicks_on_Add_Vehicle() {
		action.moveToElement(Hooks.winterTiresPage.getAddVehicle()).click().perform();
	}

	@Then("the vehicle should be added successfully")
	public void the_vehicle_should_be_added_successfully_with_a_message() {
		assertTrue(Hooks.winterTiresPage.getSuccesMsg());
	}
	
	

}
