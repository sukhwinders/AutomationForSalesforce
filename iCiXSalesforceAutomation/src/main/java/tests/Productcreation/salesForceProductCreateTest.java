package tests.Productcreation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.IdTypePageObject;
import pageObjects.SalesForceProductCreation;
import utils.generalUtils;
import utils.seleniumUtils;

public class salesForceProductCreateTest {
	
	seleniumUtils uiTools = new seleniumUtils();
	generalUtils genTools = new generalUtils();
	private WebDriver driver;
	SalesForceProductCreation salesforceprocreate = new SalesForceProductCreation();

	@BeforeMethod
	public void setup(){
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	}
	
	@Test(enabled = true , priority = 1)
    public void testNewTypeIdRequiredFields() throws Exception 
    {
		String currentTime = genTools.now();
		String login = "sdqa01jr@icix.com";
		String password = "test12345";
	
		genTools.SFDClogin(login, password);
		if(driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[2]/div/div/div[1]/span")).isDisplayed()){
			genTools.switchtoLightining();	
		}
		else
		{
			System.out.println("Element Not Found");
		}
		salesforceprocreate.sf_AppLauncher_click();
		salesforceprocreate.sf_iciximglink_click();
		salesforceprocreate.sf_ICIXProducts_button_click();
		salesforceprocreate.verifyAppLauncher();
		
		
		}
	
	@AfterMethod
	public void quitbrowser(){
		driver.quit();
	}
	
	
}
