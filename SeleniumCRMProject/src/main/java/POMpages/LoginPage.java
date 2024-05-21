package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	// WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement LoginEmail;
	
	@FindBy(xpath ="//input[@name='user_password']")
	private WebElement LoginPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginButton;
	
	public WebElement getLoginEmail() {
		return LoginEmail;
	}

	public WebElement getLoginPassword() {
		return LoginPassword;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	
	
    
}
