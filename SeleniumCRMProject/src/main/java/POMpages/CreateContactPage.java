package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//-------------------------------------------------------------------------------
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	
	public WebElement getContactLink()
	{
		return contactlink;
	}
	//--------------------------------------------------------------------------------
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactImage;
	
	public WebElement getContactImage()
	{
		return contactImage;
	}
	//---------------------------------------------------------------------------------
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	public WebElement getlastNameTextField()
	{
		return lastNameTextField;
	}
	//---------------------------------------------------------------------------------
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement createContactSaveButton;
	
	public WebElement getcreateContactSaveButton()
	{
		return createContactSaveButton;
	}
	//--------------------------------------------------------------------------------
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement SearchTextfield;
	
	public WebElement getSearchTextField()
	{
		return SearchTextfield;		
	}
	//-----------------------------------------------------------------------------------
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement InDropdown;
	public WebElement getInDropDown()
	{
		return InDropdown;
	}
	//------------------------------------------------------------------------------------
	@FindBy(xpath="//input[@name='submit']")
	public WebElement SearchButton;
	
	public WebElement getSearchButton()
	{
		return SearchButton;
	}
	//-----------------------------------------------------------------------------------
	@FindBy(name="support_end_date")
    public WebElement SupportEndDate;
	
	public WebElement getSupportEndDate()
	{
		return SupportEndDate;
	}
	//-------------------------------------------------------------------------------------
	@FindBy(name="support_start_date")
	public WebElement SupportStartDate;
		
	public WebElement getSupportStartDate()
	{
		return SupportStartDate;
	}
	
	

}
