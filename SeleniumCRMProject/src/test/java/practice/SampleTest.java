package practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ListenerClass;
//@Listeners(GenericUtility.ListenerClass.class)

    public class SampleTest  {
	//WebDriver driver;
	@Test
	public void program(Method mtd) throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		System.out.println("Application launched");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Login to the application successfull");
		String actTitle = driver.getTitle();
		Assert.assertTrue(actTitle.contains("login"));
		
		
		String time = new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(time);
		String methodname = mtd.getName();
		System.out.println(methodname);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./ScreenShotFolder/"+methodname+" "+time+".png");
		FileUtils.copyFile(source, destination);
		
		
		
		
		//File source=ts.getScreenshotAs(OutputType.FILE);
		//File destination=new File("./ScreenShotFolder/"+methodname+" "+time+".png");
		//FileUtils.copyFile(source, destination);
		driver.close();
	}

}
