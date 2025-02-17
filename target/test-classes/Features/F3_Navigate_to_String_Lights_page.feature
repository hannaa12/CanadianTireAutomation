# Author: Hani Saravanan
# Date: Jan. 29, 2025 
@NavigateToStringLights
Feature: As a user, I want to navigate to String Lights page

  Scenario: Navigate to String Lights page
    Given the user navigates to the Canadian Tire homepage
    And the user handles the pop-ups
    When the user clicks on Shop by Department dropdown
    And the user selects Outdoor Living and clicks on Outdoor Lighting
    And the user clicks on String Lights
    Then the String Lights page is displayed
