package GenericUtility;

import java.sql.SQLException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import POMpages.HomePage;
import POMpages.LoginPage;
//@Listeners(GenericUtility.Listener.class)

public class BaseClass {

	public  WebDriver driver;// Webdriver object
	public static WebDriver sdriver;//another driver object for taking screenshot
	public FileUtility flib = new FileUtility();// FileUtility class
	public WebDriverUtility wlib = new WebDriverUtility();// webdriverUtility class
	public LoginPage lp;// login page
	public HomePage hp;// homepage
	//public ExtentTest test;

	public DataBaseUtility dlib;
	// ------------------------new concept
	// added---------------------------------------
	// creation of static webdriver
	//public static WebDriver sdriver;

	// ---------------------------------------------------------------
	/**
	 * Database connection and concept added
	 * 
	 * @throws SQLException
	 */
	@BeforeSuite
	public void connectServer() throws SQLException {
		Reporter.log("=============Connected to server========", true);
		// dlib.getDBConnection();
		Reporter.log("=============Connected To DB=============", true);
	}

	/**
	 * opening the browser concept added
	 * 
	 * @throws Throwable
	 */
	@BeforeClass
	public void openBrowser() throws Throwable {
		String Browser = flib.getDataFromPropertiesFile("browser");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		// ---------------------new concept
		// added-----------------------------------------------
		sdriver = driver;// this will store the sessionid of driver in sdriver
		// ----------------------------------------------------------------------
		UtilityClassObject.setDriver(driver);
	}

	/**
	 * Navigate to URL and login to the Application
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod
	public void login() throws Throwable {

		String URL = flib.getDataFromPropertiesFile("url");
		System.out.println(URL);
		driver.get(URL);
		Reporter.log("launch the Application", true);
		wlib.maximize(driver);
		wlib.iplicitWait(driver);
		String UserName = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		lp = new LoginPage(driver);
		lp.getLoginEmail().sendKeys(UserName);
		lp.getLoginPassword().sendKeys(Password);
		lp.getLoginButton().click();
		Reporter.log("login to the Application", true);
	}

	// @Test
	// public void test()
	// {
	// Reporter.log("executing ts", true);
	// }
	/**
	 * Logout from application
	 */
	@AfterMethod
	public void logout() {
		hp = new HomePage(driver);
		hp.getSignOut();
		Reporter.log("logout from the Application", true);
	}

	/**
	 * Close the browser
	 */
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed", true);
	}

	/**
	 * @throws SQLException disconnection from server and Db
	 */
	@AfterSuite
	public void disconnectServer() throws SQLException {
		Reporter.log("disConnected from server", true);
		// dlib.closeDBConnection();
		Reporter.log("disConnected from Database", true);
       
	}
}
