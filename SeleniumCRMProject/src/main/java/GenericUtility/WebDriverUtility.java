package GenericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * Used for implicitwait
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void iplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * Used for Explicitwait
	 * @param driver
	 * @param element
	 */
	public void explicitWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * used for switch window based on URL
	 * @param driver
	 * @param PartURL
	 */
	public void switchToWindowBasedOnURL(WebDriver driver,String PartialURL)
	{
		Set<String> allwindow = driver.getWindowHandles();
	    for(String windowid:allwindow)
	    {
	    	driver.switchTo().window(windowid);
	    	String actualResult = driver.getCurrentUrl();
	    	if(actualResult.contains(PartialURL))
	    	{
	    		break;
	    	}
	    }	
		
	}
	/**
	 * used for switch window based on Title
	 * @param driver
	 * @param PartURL
	 */
	public void switchToWindowBasedOnTitle(WebDriver driver,String PartialTitle)
	{
		Set<String> allwindow = driver.getWindowHandles();
	    for(String windowid:allwindow)
	    {
	    	driver.switchTo().window(windowid);
	    	String actualResult = driver.getTitle();
	    	if(actualResult.contains(PartialTitle))
	    	{
	    		break;
	    	}
	    }	
	}
	
	/**
	 * used to switch frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		 driver.switchTo().frame(index);
	}
	/**
	 * used to switch frame based on name and id
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,String NameAndId)
	{
		 driver.switchTo().frame(NameAndId);
	}
	/**
	 * used to switch frame based on name and id
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		 driver.switchTo().frame(element);
	}
	/**
	 * used to switch handle alert with accept method
	 * @param driver
	 */
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch handle alert with dismiss method
	 * @param driver
	 */
	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to handle dropdown using index
	 * @param element
	 * @param string
	 */
	public void dropdownHandleByIndex(WebElement element,int string)
	{
		Select s=new Select(element);
		s.selectByIndex(string);
	}
	/**
	 * used to handle dropdown using visibletext
	 * @param element
	 * @param index
	 */
	public void  dropdownHandleByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to select element from drop down using  value
	 * @param value
	 * @param element
	 */		
	public static void dropDown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);	
	}
	/**
	 * used to do mouse over actions
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	/**
	 * This method is used to right click on the element
	 * @param driver
	 * @param element
	 */
	public static void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to double click on the element
	 * @param element
	 */
	public static void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to click on the element
	 * @param element
	 */
	public static void clickElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
}
