# ToDoSeleniumTesting

Contains the front end testing for the ToDo Project, done in Eclipse using Selenium. Each Page has a folder that contains screenshots of how the testing is happening below is a demo of how adding a task to the project is tested: 
```
@Test
	public void createTaskTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		CreateTask task = PageFactory.initElements(driver, CreateTask.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot1.png");
		webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot2.png");
		LOGGER.warning("Clicks add a task link");
		webpage.navCreateTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot3.png");
		LOGGER.warning("Enter info and click submit");
		task.createaTask("1", "To Buy", "Cake");
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot4.png");
		
		LOGGER.info("Finished");
		 boolean expected;
	     expected = true;
	     Boolean result = driver.getPageSource().contains("1");
	     System.out.println(result);
	
	       
        assertEquals(expected, result);
        
    	if ((expected = true) && (result = true)) {
			test.log(LogStatus.PASS, "Success created task");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
    	
    	webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot5.png");
		
	}
```
driver.get(HomeNav.URL); goes to the index page:

![](/src/test/resources/reports/createtask/shot1.png)

Then with webpage.navReadAllTaskPage(); we call this method which clicks the read all tasks button and takes you to the following page :

![](/src/test/resources/reports/createtask/shot2.png)
This is to show all the current tasks in the system so we can compare at the end if a task is added during our test or not 

Next webpage.navCreateTaskPage(); takes you to the create a task page: 

![](/src/test/resources/reports/createtask/shot3.png)

Then task.createaTask("1", "To Buy", "Cake"); the createatask method takes in the three parameters and automatically enters the paramaters the methods code is: 
```
public void createaTask(String userid, String name, String body) {
		userIdField.sendKeys(userid);
		nameField.sendKeys(name);
		bodyField.sendKeys(body);
		saveTask.click();
	}
```
because the code is modulate we can call this method in our test and have it do all the code within it, once the method is ran it shows the following output:

![](/src/test/resources/reports/createtask/shot4.png)

Then we run an assertsEqual to test if its actually done what it is supposed to do and see if that passes 

And finally we go back to the read all tasks page to see if the task has been added 

```
webpage.navReadAllTaskPage();
```

This shows the following 

![](/src/test/resources/reports/createtask/shot5.png)

From this we can see that we only had 4 tasks before now we have 5 with the correct fields, 

You can follow the screenshot for each page in /src/test/resources/reports/ each page has it own folder to see how everypage is automatically tested 







