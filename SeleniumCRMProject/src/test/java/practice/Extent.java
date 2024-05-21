package practice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import GenericUtility.BaseClass;
import junit.framework.Assert;
@Listeners(GenericUtility.Listener.class)
public class Extent extends BaseClass {
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeSuite
	public void configureBS()
	{
		//Spark Report Config
		spark=new ExtentSparkReporter("./ExtentReport/report.png");
		spark.config().setDocumentTitle("CRM Application Suite Result");
		spark.config().setReportName("CRM Application Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//Add Environment Info
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Window-10");
		report.setSystemInfo("browser","chrome-100");	
	}
	/**
	 * Script 1
	 */
	@Test
	public void sampleTest1()
	{
			
	test=report.createTest("sampleTest1");
	test.log(Status.INFO,"Open Browser");
	test.log(Status.INFO,"Launch URL");
	test.log(Status.INFO,"Login To The Application");
	Assert.assertEquals("HDFC", "HDFC");
	//report.flush();
	}
	/**
	 * Script 2
	 */
	@Test
	public void sampleTest2()
	{
	test=report.createTest("sampleTest2");
	test.log(Status.INFO,"Open Browser");
	test.log(Status.INFO,"Launch URL");
	test.log(Status.INFO,"Login To The Application");
	Assert.assertEquals("HDFC", "HDFF");
	}
	@AfterSuite
	public void configureAS()
	{
		report.flush();
	}

}
