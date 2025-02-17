# Author: Hani Saravanan
# Date: Jan. 28, 2025
@ChangeStore&AddToCart
Feature: As a user, for an item from Canadian Tire, I want to change the store loction and add it to the cart
  		 while verifying all intermediate steps.

  Scenario: Change the store loction and add it to the cart
    Given the user navigates to the item page
    When the user selects "Pick Up" and clicks on Check other stores
    And the user clicks on "Verdun, QC"
    Then the user confirms the store selection
    And the user clicks on the Add to Cart button
    
   
