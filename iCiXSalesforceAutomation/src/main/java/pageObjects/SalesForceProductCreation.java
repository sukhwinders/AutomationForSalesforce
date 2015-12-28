package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
 
public class SalesForceProductCreation {
	
	private WebDriver driver;
	  
	// Web Elements for clicking App luancher.
	@FindBy(xpath="(//a[contains(@href, 'javascript:void(0);')])[6]")
	WebElement applaunchericon;
	
	 // for clicking ICIX link after clicking the app launcher.
	   @FindBy(xpath="//img[@alt='ICIX']")
	   WebElement iciximglink;
	  
	// for clicking ICIX link after clicking the app launcher.
	   @FindBy(xpath="//a[contains(@href, 'https://sdqa01-dev-ed.my.salesforce.com/a0N/o')]")
	   WebElement icixproductslink;
	   
	// for clicking ICIX link after clicking the app launcher.
	   @FindBy(xpath="//div[2]/div/div/ul/li/a/div")
	   WebElement New_Products_Button;
	 
  
	   public static final String AppLauncher	= "//section[@id='header']/div/h1";  
	   public static final String DescriptionLabel	= "//div[2]/div/label";
	   
	   public void verifyAppLauncher()throws Exception
	   {
	   WebElement element = driver.findElement(By.xpath(AppLauncher));
	   String strng = element.getText();
	   System.out.println(strng);
	   Assert.assertEquals("App Launcher", strng);
	   }
	   	   
	   public void verifyICIXPagenavigation()throws Exception
	   {
	   	   WebElement element = driver.findElement(By.xpath(DescriptionLabel));
	   String strng = element.getText();
	   System.out.println(strng);
	   Assert.assertEquals("Description", strng);
	   }

	   
	 //To click on ICIX on image on app launcher screen.
		 public SalesForceProductCreation sf_AppLauncher_click() {
			 applaunchericon.click();
			 return PageFactory.initElements(driver, SalesForceProductCreation.class);
		         
		   }	 
		//To click on specfic ICIX products link on list page.
		 public SalesForceProductCreation sf_iciximglink_click() {
			     iciximglink.click();
				 return PageFactory.initElements(driver, SalesForceProductCreation.class);
			         
			   }
		 
		//To click on Create New Button on Products page.
		 public SalesForceProductCreation sf_ICIXProducts_button_click() {
			 New_Products_Button.click();
				 return PageFactory.initElements(driver, SalesForceProductCreation.class);
			         
			   }
		 
		 
		 

}
