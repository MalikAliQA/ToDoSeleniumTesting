package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateTask {
	
	@FindBy(css = "#commentName") 
	WebElement nameField;
	
	@FindBy(css = "#commentBody")
	WebElement bodyField;
	
	@FindBy(css = "body > div > form > button")
	WebElement updateTask;
	
	public void updateaTask(String name, String body) {
		nameField.clear();
		nameField.sendKeys(name);
		bodyField.clear();
		bodyField.sendKeys(body);
		updateTask.click();
	}

}
