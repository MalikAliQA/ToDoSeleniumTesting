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
The first thing it does it go to the index page:

![](/src/test/resources/reports/createtask/shot1.png)
