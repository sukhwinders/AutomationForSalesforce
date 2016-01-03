package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SF_HomePage {
	
	private WebDriver driver;
	  
	   @FindBy(xpath=".//*[@id='username']")
	   WebElement username;
	  
	   @FindBy(xpath=".//*[@id='password']")
	   WebElement password;
	  
	   @FindBy(xpath=".//*[@id='Login']")
	   WebElement loginButton;
	   
	   @FindBy(className="oneUserProfileCardTrigger")
	   WebElement salesForce_profile_icon;
	   
	 //Salesforce elements after switching to the Lighting mode.
	   //@FindBy(xpath="//*[@id='oneHeader']/div[2]/div[3]/a[1]")
	   @FindBy(xpath="//*[@alt='App Launcher']")
	   WebElement salesForce_applauncher;
	   
	 //Salesforce elements after switching to the Lighting mode.
	   @FindBy(xpath="html/body/div[5]/div[3]/div/div/div/div/div/div[4]/a[1]")
	   WebElement logoutButton;
	   
	   @FindBy(xpath=".//*[@id='userNav-arrow']")
	   WebElement Switcharrow;
	  
	   @FindBy(xpath="//a[text()='Switch to Lightning Experience']")
	   WebElement Switchtolighlink;
	   
	   @FindBy(id="simpleDialog0button0")
	  public static WebElement Switchtolighpopup;
	   
	   //Function to enter valid credentials to the app.
	   public SF_HomePage entercredentials(String uname,String passwd) {
		   username.sendKeys(uname);
		   password.sendKeys(passwd);
		   return PageFactory.initElements(driver, SF_HomePage.class);
	         
	   }
	   
	 //Function to click the Login button after entering valid credentials on the home page.
	   public SF_HomePage LoginSF() {
		   loginButton.click();
		   return PageFactory.initElements(driver, SF_HomePage.class);
	         
	   }
	 //Function to click the Applauncher image after user is switched to Lightining.
	   public SF_HomePage Applaunchericon() {
		   salesForce_applauncher.click();
		   return PageFactory.initElements(driver, SF_HomePage.class);
	         
	   }
	   //Function to Logout of the applicaton
	   public SF_HomePage LogoutSF() {
		   salesForce_profile_icon.click();
		   logoutButton.click();
		   return PageFactory.initElements(driver, SF_HomePage.class);
	         
	   } 

}
