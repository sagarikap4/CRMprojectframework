package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//------------------------------------------------------
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationName;
	
	public WebElement getOrganizationName()
	{
		return OrganizationName;	
	}
	//------------------------------------------------------
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
		
	public WebElement getIndustryDropDown()
		{
			return IndustryDropDown;
		}
	//------------------------------------------------------
	@FindBy(name="accounttype")
	private WebElement TypeDropDown;
				
	public WebElement getTypeDropDown()	
	{
		return TypeDropDown;
	}
	//----------------------------------------------------------
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement CreateORGSaveButton;
	
	public WebElement getCreateORGSaveButton()	
	{
		return CreateORGSaveButton;
	}

}
