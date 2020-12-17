package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateUser {
	
	@FindBy(css = "#commentName") 
	WebElement nameField;
	
	
	@FindBy(css = "body > div > form > button")
	WebElement updateUser;
	

	
	public void updateaUser(String name) {
		nameField.clear();
		nameField.sendKeys(name);
		updateUser.click();
	}

}
