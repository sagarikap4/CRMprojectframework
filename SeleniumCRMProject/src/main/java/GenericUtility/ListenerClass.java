package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass implements ITestListener,ISuiteListener {
	
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		
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

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		System.out.println("Report backup");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Execution Start");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Execution End");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName);
		String time = new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(time);
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File source=edriver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./ScreenShotFolder/"+testScriptName+" "+time+".png");
		//File destination=new File("./ScreenShotFolder/"+time+"test.png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
