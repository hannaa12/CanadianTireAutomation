package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.TimeoutException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fdmgroup.data.DataFile;
import com.fdmgroup.utilities.ExtentReportManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F3_Navigate_to_String_Lights_Page_StepDef {
	
	@Given("the user navigates to the Canadian Tire homepage")
	public void the_user_navigates_to_the_canadian_tire_homepage() throws InterruptedException {

		try {
			Hooks.driver.navigate().to(DataFile.CanadianTireURL);
			Thread.sleep(90000);
		} catch (TimeoutException e) {
		}
	}

	@Given("the user handles the pop-ups")
	public void the_user_handles_the_pop_ups() {
		Hooks.homePage.handlePopUps();
		Hooks.homePage.handleOfferBanner();
	}
	
	@When("the user clicks on Shop by Department dropdown")
	public void the_user_clicks_on_shop_by_department_dropdown() {
		Hooks.homePage.clickOnShopByDepartment();
	}

	@When("the user selects Outdoor Living and clicks on Outdoor Lighting")
	public void the_user_selects_outdoor_living_and_clicks_on_outdoor_lighting() {
		Hooks.homePage.clickOnOutdoorLiving();
		Hooks.homePage.clickOnOutdoorLighting();
	}
	
	@When("the user clicks on String Lights")
	public void the_user_clicks_on_String_Lights() {
		Hooks.homePage.clickOnStringLights();
	}
	
	@Then("the String Lights page is displayed")
	public void the_string_lights_is_displayed() {
		assertTrue(Hooks.outdoorLightingPage.isStringLightsPageDisplayed());
	}
}



