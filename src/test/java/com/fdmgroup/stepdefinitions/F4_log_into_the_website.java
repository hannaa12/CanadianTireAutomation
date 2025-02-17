package com.fdmgroup.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import com.fdmgroup.data.DataFile;
import com.fdmgroup.utilities.ExcelUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class F4_log_into_the_website {
	
	 @Given("User navigates to the Sign In page")
	    public void user_navigates_to_the_Sign_In_page() {
	    	 Hooks.driver.get(DataFile.LoginPageURL);
	    }


    @Then("User logs in using data from Excel sheet called {string} and results are stored in the Excel sheet")
    public void user_logs_in_using_data_from_Excel_sheet(String sheetName) throws IOException, InterruptedException {
    	
    	Hooks.driver.manage().deleteAllCookies();
    	JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.localStorage.clear();");
        js.executeScript("window.sessionStorage.clear();");

    	
        String usersExcelPath = "src/test/java/com/fdmgroup/data/Users.xlsx"; 
        String resultsExcelPath = "src/test/java/com/fdmgroup/data/Results.xlsx";
        
        int rowCount = ExcelUtilities.getRowCount(usersExcelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) { 
            String username = ExcelUtilities.getCellData(usersExcelPath, sheetName, i, 0);
            String password = ExcelUtilities.getCellData(usersExcelPath, sheetName, i, 1);

            Hooks.loginPage.setUsernameField(username);
            Hooks.loginPage.setPasswordField(password);
            Hooks.loginPage.clickOnSignInButton();

            // Validate login 
            Hooks.loginPage.validateLoginToFillExcelSheet(resultsExcelPath, "Result", i, 0);
            
            System.out.println("Row: "+ i);

            Thread.sleep(60000); // Wait 5 seconds before trying the next login

            Hooks.driver.navigate().refresh(); // Reset for next user
            
        }
    }
}
