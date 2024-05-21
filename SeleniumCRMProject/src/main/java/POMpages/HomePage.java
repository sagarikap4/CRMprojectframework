package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    //-----------------------------------------------------------------------------------
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement OrganizationLnk;
	
	public WebElement clickOrganizationLink()
	{
		return OrganizationLnk;	
	}
	//---------------------------------------------------------------------------------------
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationImage;
	
	public WebElement getCreateOrganizationImage()
	{
		return createOrganizationImage;
	}
	//----------------------------------------------------------------------------------
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Signout;
	
	public WebElement getSignOut()
	{
		return Signout;
		
	}

}
