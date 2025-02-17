# Author: Hani Saravanan
# Date: Feb. 3, 2025
@login
Feature: Login Feature

  Scenario: Login with multiple users from Excel
    Given User navigates to the Sign In page
    Then User logs in using data from Excel sheet called "Users" and results are stored in the Excel sheet
