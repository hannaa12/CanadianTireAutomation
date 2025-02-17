# Author: Hani Saravanan
# Date: Jan. 29, 2025
@AddWinterTireVehicle
Feature: As a user, I want to add a new vehicle to the system so that I can choose tire for it

  Scenario: User selects a vehicle and adds it to the system
    Given the user is on the Add New Vehicle page
    When the user selects ATV & UTV as Vehicle Type
    And the user selects 2024 as Year
    And the user selects Arctic Cat as Make
    And the user selects Alterra 300 as Model
    And the user clicks on Add Vehicle
    Then the vehicle should be added successfully