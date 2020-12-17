package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeNav {
	
public static final String URL = "localhost:9092/index.html";
	
	@FindBy(css = "#navbarSupportedContent > ul > li:nth-child(2) > a")
	private WebElement createTaskLink;
	
	@FindBy(css = "#navbarSupportedContent > ul > li:nth-child(3) > a")
	private WebElement readAllTaskLink;
	
	@FindBy(css = "body > div > table > thead > tr:nth-child(2) > td:nth-child(4) > a")
	private WebElement updateTask1Link;
	
	@FindBy(css = "body > div > table > thead > tr:nth-child(2) > td:nth-child(5) > button")
	private WebElement deleteTask1Link;
	
	@FindBy(css = "#navbarSupportedContent > ul > li:nth-child(5) > a")
	private WebElement createUserLink;
	

	@FindBy(css = "#navbarSupportedContent > ul > li:nth-child(6) > a")
	private WebElement readAllUserLink;
	
	@FindBy(css = "body > div > table > thead > tr:nth-child(3) > td:nth-child(4) > a")
	private WebElement updateUser2Link;
	
	@FindBy(css = "body > div > table > thead > tr:nth-child(4) > td:nth-child(5) > button")
	private WebElement deleteUser3Link;
		

	public void navCreateTaskPage() {
		createTaskLink.click();
	}
	
	public void navReadAllTaskPage() {
		readAllTaskLink.click();
	}
	
	public void navUpdateTaskPage() {
		updateTask1Link.click();	
	}
	
	public void navDeleteTaskPage() {
		deleteTask1Link.click();
	}
	
	public void navCreateUserPage() {
		createUserLink.click();
	}
	
	public void navReadAllUserPage() {
		readAllUserLink.click();
	}
	
	public void navUpdateUserPage() {
		updateUser2Link.click();	
	}
	
	public void navDeleteUserPage() {
		deleteUser3Link.click();
	}


}
