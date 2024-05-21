package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInformationPage {
	public CreateOrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//-----------------------------------------------------------------
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgNameInfoPage;
	
	public WebElement getOrgNameInfoPage()
	{
		return OrgNameInfoPage;
	}
	//-----------------------------------------------------------------
	@FindBy(id="dtlview_Industry")
	private WebElement OrgIndustryNameInfoPage;
	
	public WebElement getOrgIndustryNameInfoPage()
	{
		return OrgIndustryNameInfoPage;
	}
	//-----------------------------------------------------------------
	@FindBy(id="dtlview_Industry")
	private WebElement OrgTypeNameInfoPage;
	
	public WebElement getOrgTypeNameInfoPage()
	{
		return OrgTypeNameInfoPage;
	}
	

}
