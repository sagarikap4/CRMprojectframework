package Organization;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ListenerClass;

@Listeners(GenericUtility.ListenerClass.class)
public class ProgramithListenerTest extends BaseClass {
	@Test
	public void createInvoiceTest(Method mtd)
	{
		//String methodname = mtd.getName();
		System.out.println("Execution createInvoiceTest Start");
		String actTitle = driver.getTitle();
		Assert.assertTrue(actTitle.contains("login"));
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("Execution createInvoiceTest End");
	}
	@Test
	public void createTest(Method mtd1)
	{
		//String methodname1 = mtd1.getName();
		System.out.println("Execution createTest Start");
		//String actTitle = driver.getTitle();
		//Assert.assertEquals(actTitle, "Home Page");
		System.out.println("step-3");
		System.out.println("step-4");
		System.out.println("Execution createTest End");
	}

	
	
	
	

}
