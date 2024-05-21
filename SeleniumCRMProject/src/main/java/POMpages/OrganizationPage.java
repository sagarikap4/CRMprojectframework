package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchTextField() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
