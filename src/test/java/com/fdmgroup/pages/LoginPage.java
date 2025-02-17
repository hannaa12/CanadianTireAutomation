package com.fdmgroup.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.stepdefinitions.Hooks;
import com.fdmgroup.utilities.ExcelUtilities;

public class LoginPage {
	
	WebDriver driver;
	
	// Constructor to initialize the WebDriver and WebElements
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//div/div[2]/span//input[@name='username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//div/div/div[2]/span/section//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Sign In']")
	WebElement signInButton;
	
	// Locate elements and perform login
    
    
	public void setUsernameField(String username) {
		
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void setPasswordField(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

//	public void validateLoginToFillExcelSheet(String excelPath, String sheetName, int i, int col) throws IOException {
//		boolean verificationHeading = false;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Wait max 5 seconds
//            verificationHeading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Verify Your Triangle ID']\n"))) != null;
//        } catch (Exception e) {
//        	verificationHeading = false; // If element is not found within timeout, set to false
//        }
//        if (verificationHeading) {
//            ExcelUtilities.fillGreenColor(excelPath, sheetName, i, col); // Mark as Passed
//        } else {
//            ExcelUtilities.fillRedColor(excelPath, sheetName, i, col); // Mark as Failed
//        }		
//	}
	
	
	public void validateLoginToFillExcelSheet(String excelPath, String sheetName, int row, int col) throws IOException {
	    boolean verificationHeading = false;
	    
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait max 5 seconds
	        verificationHeading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Verify Your Triangle ID']"))) != null;
	    } catch (Exception e) {
	        verificationHeading = false; // If element is not found within timeout, set to false
	    }

	    if (!ExcelUtilities.doesExcelFileExist(excelPath)) {
	        ExcelUtilities.createExcelFile(excelPath, sheetName); // Create the workbook if it doesn't exist
	    }

	    if (!ExcelUtilities.doesSheetExist(excelPath, sheetName)) {
	        ExcelUtilities.createSheet(excelPath, sheetName); // Create the sheet if it doesn't exist
	    }
 
	    // Fill Green for success, Red for failure
	    if (verificationHeading) {
	        ExcelUtilities.fillGreenColor(excelPath, sheetName, row, col); 
	    } else {
	        ExcelUtilities.fillRedColor(excelPath, sheetName, row, col);
	    }
	}
}
