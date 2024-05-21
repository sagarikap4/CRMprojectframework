package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.UtilityClassObject;
import POMpages.CreateOrganizationPage;
import POMpages.HomePage;

//@Listeners(GenericUtility.Listener.class)
public class Program extends BaseClass {
	CreateOrganizationPage cp;// create organization class
	ExcelUtility elib = new ExcelUtility();// create exelutility class
	JavaUtility jlib = new JavaUtility();

	@Test
	public void createORG() {
		UtilityClassObject.getTest().log(Status.FAIL,"Execotion Start");
		cp = new CreateOrganizationPage(driver);
		hp = new HomePage(driver);
		hp.clickOrganizationLink().click();
		UtilityClassObject.getTest().log(Status.FAIL,"Clicked on organization link");
		String organizationtitle = driver.getTitle();
		Assert.assertTrue(organizationtitle.equals("Commercial Open Source CRM"));

		hp.getCreateOrganizationImage().click();
		UtilityClassObject.getTest().log(Status.FAIL,"Clicked on create new organization");
		
	}

}
