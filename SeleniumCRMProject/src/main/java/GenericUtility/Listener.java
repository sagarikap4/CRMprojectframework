package GenericUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	//ExtentTest test=new ExtentTest();

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String time1 = new Date().toString().replace(" ", "_").replace(":", "_");
		//========================= Spark Report Config=================================
		spark = new ExtentSparkReporter("./ExtentReport/report"+time1+".html");
		spark.config().setDocumentTitle("CRM Application Suite Result");
		spark.config().setReportName("CRM Application Report");
		spark.config().setTheme(Theme.STANDARD);
		//==================== Add Environment Info========================================
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("browser", "chrome-100");
	}
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Execution Start");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
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
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String sourceimage = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(sourceimage, testScriptName+"----"+time);	
		test.log(Status.FAIL,result.getMethod().getMethodName()+"=====FAIL=====");
	}
}
