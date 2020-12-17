package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
	


	@FindBy(css = "#commentName") 
	WebElement nameField;
	
	
	@FindBy(css = "body > div > form > button")
	WebElement saveUser;
	

	
	public void createaTask(String name) {
		nameField.sendKeys(name);
		saveUser.click();
	}

}
