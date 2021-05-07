package com.qa.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.CreateTask;
import com.qa.pages.CreateUser;
import com.qa.helper.Helper;
import com.qa.pages.HomeNav;
import com.qa.pages.UpdateTask;
import com.qa.pages.UpdateUser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ToDoTesting {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest test;
	//Helper help =  new Helper();
	
	
    private static Logger LOGGER = Logger.getGlobal();
	
	
	@BeforeClass
	public static void init() {
		
		
		extent = new ExtentReports("src/test/resources/reports/report1.html", true);
		test = extent.startTest("ToDo project Testing");;
		
		System.setProperty("webdriver.chrome.driver", 
				"src/test/resources/resources/drivers/chromedriver.exe");
		
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		
		driver = new ChromeDriver(cOptions);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	

	@AfterClass
	public static void tearDown() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		extent.close();
		
	}
	
	@Test
	public void createTaskTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		CreateTask task = PageFactory.initElements(driver, CreateTask.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/createtask/shot1.png");
		Thread.sleep(1000);
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
	
	@Test
	public void readAllTaskTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/readalltask/shot1.png");
		LOGGER.warning("Clicks read all task link");
		webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/readalltask/shot2.png");
			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readAll.html";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);
	
	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success read all task");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
		
	}
	
	@Test
	public void updateTaskTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		UpdateTask updatetask = PageFactory.initElements(driver, UpdateTask.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/updatetask/shot1.png");
		LOGGER.warning("Clicks read all task link");
		webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/updatetask/shot2.png");
		LOGGER.warning("Clicks view one task link");
		webpage.navUpdateTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/updatetask/shot3.png");
		LOGGER.warning("Enter info and click submit");
		updatetask.updateaTask("TO CLEAN: ", "ROOM");
		Helper.snapShot(driver, "src/test/resources/reports/updatetask/shot4.png");
			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readOne.html?id=1";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success update task");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
    	
    	webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/updatetask/shot5.png");
    	
		
	}
	
	@Test
	public void deleteTaskTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/deletetask/shot1.png");
		LOGGER.warning("Clicks read all task link");
		webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/deletetask/shot2.png");
		LOGGER.warning("Clicks delete task 1 link");
		webpage.navDeleteTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/deletetask/shot3.png");

			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readAll.html";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success deleted task");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
    	
    	webpage.navReadAllTaskPage();
		Helper.snapShot(driver, "src/test/resources/reports/deletetask/shot4.png");
    	
		
	}
	
	@Test
	public void createUserTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		CreateUser user = PageFactory.initElements(driver, CreateUser.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/createuser/shot1.png");
		webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/createuser/shot2.png");
		LOGGER.warning("Clicks add a user link");
		webpage.navCreateUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/createuser/shot3.png");
		LOGGER.warning("Enter info and click submit");
		user.createaTask("Winston");
		Helper.snapShot(driver, "src/test/resources/reports/createuser/shot4.png");
		
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/createuser.html";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);
	
	       
       assertEquals(expected, result);
       
   	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success create a users");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
   	
   	webpage.navReadAllUserPage();
	Helper.snapShot(driver, "src/test/resources/reports/createuser/shot5.png");
		
	}
	
	@Test
	public void readAllUsersTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/readalluser/shot1.png");
		LOGGER.warning("Clicks read all user link");
		webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/readalluser/shot2.png");
			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readAlluser.html";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);
	
	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success read all users");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
		
	}
	
	@Test
	public void updateUserTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		UpdateUser updatetask = PageFactory.initElements(driver, UpdateUser.class);

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/updateuser/shot1.png");
		LOGGER.warning("Clicks read all users link");
		webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/updateuser/shot2.png");
		LOGGER.warning("Clicks view one user link");
		webpage.navUpdateUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/updateuser/shot3.png");
		LOGGER.warning("Enter info and click submit");
		updatetask.updateaUser("Rein");
		Helper.snapShot(driver, "src/test/resources/reports/updateuser/shot4.png");
			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readOneuser.html?id=2";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success updated user");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
    	
    	webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/updateuser/shot5.png");
    	
		
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		LOGGER.warning("connecting to ToDo Site");
		HomeNav webpage = PageFactory.initElements(driver, HomeNav.class);
		

		
		driver.get(HomeNav.URL);
		Helper.snapShot(driver, "src/test/resources/reports/deleteuser/shot1.png");
		LOGGER.warning("Clicks read all users link");
		webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/deleteuser/shot2.png");
		LOGGER.warning("Clicks delete user 3 link");
		webpage.navDeleteUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/deleteuser/shot3.png");

			
		LOGGER.info("Finished");
	     String expected = "http://localhost:9092/readAlluser.html";
	     String result = driver.getCurrentUrl();
	     System.out.println(result);	       
        assertEquals(expected, result);
        
    	if ((expected).equals(result)) {
			test.log(LogStatus.PASS, "Success deleted user");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}
    	
    	webpage.navReadAllUserPage();
		Helper.snapShot(driver, "src/test/resources/reports/deleteuser/shot4.png");
    	
		
	}
	
	

}
