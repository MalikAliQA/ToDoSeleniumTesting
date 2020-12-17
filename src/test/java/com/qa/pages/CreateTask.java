package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTask {
	
	
	@FindBy(css = "#commentUserId")
	WebElement userIdField;

	@FindBy(css = "#commentName") 
	WebElement nameField;
	
	@FindBy(css = "#commentBody")
	WebElement bodyField;
	
	@FindBy(css = "body > div > form > button")
	WebElement saveTask;
	

	
	public void createaTask(String userid, String name, String body) {
		userIdField.sendKeys(userid);
		nameField.sendKeys(name);
		bodyField.sendKeys(body);
		saveTask.click();
	}
	

}
