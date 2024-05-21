package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {
	public CreateContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//------------------------------------------------------------------
	@FindBy(xpath="//td[@id='mouseArea_Last Name']")
	private WebElement LastNameContactInfoPage;
	
	public WebElement getLastNameContactInfoPage()
	{
		return LastNameContactInfoPage;
	}
	//---------------------------------------------------------------
	@FindBy(id="dtlview_Support Start Date")
	private WebElement SupportStartDateInfoPage;
	
	public WebElement getSupportStartDateInfoPage()
	{
		return SupportStartDateInfoPage;
	}
	//-----------------------------------------------------------------
	@FindBy(id="dtlview_Support End Date")
	private WebElement SupportEndDateInfoPage;
	
	public WebElement getSupportEndDateInfoPage()
	{
		return SupportEndDateInfoPage;
	}

}
