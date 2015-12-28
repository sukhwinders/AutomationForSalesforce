package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdTypePageObject {
//  private String currentTime;
/////    private Describe describe = new Describe();
  private WebDriver driver;
//  private String organization = "";

	
/// Locator values
	String waffle 		= "//div[@class='icon-waffle']";
	String othertItems 	= "//img[@alt='Other Items']";
	String showAlltabs 	= "//img[@alt='All Tabs']";
///	String idTypes 		= "//a[@href='https://sdqa01-dev-ed.my.salesforce.com/a0P/o']";
	String idTypes 		= "//a[contains(.,'Id Types')]";
	String idTypesURL 	= "https://sdqa01-dev-ed.my.salesforce.com/a0P/o";
	String newButton	= "//input[@title='New']";
	public static final String editButton	= "//input[@name='edit']";
	public static final String idTypeName 	= "//input[@id='Name']";
	public static final String idTypeName2 	= "//div[@id='Name_ileinner']";
	
	public static final String UniqueId		= "Unique Id";
	
	
	String saveButton	= "//input[@value=' Save ']";
	
	WebDriverWait wait = new WebDriverWait(driver, 15);

	
/////////////////////////////////////////////////////////////
	
/*  public IdTypePageObject(WebDriver driver) {
	this.driver = driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
  }*/

  public void navigateToNewObject() throws Exception {
//		 String url = "https://sdqa01-dev-ed.my.salesforce.com/a0P/o";
//		driver.get(url);
  	Thread.sleep(3000);
  	
  	
/*    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(waffle)));
  	driver.findElement(By.xpath(waffle)).click();
  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(othetItems)));
  	driver.findElement(By.xpath(othertItems)).click();
  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(idTypes)));
  	driver.get(idTypesURL);
///   	driver.findElement(By.xpath(idTypes)).click();
  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newButton)));

*/   	
  	driver.findElement(By.xpath(showAlltabs)).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(idTypes)));

  	driver.findElement(By.xpath(idTypes)).click();  
  	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newButton)));
  	
  	driver.findElement(By.xpath(newButton)).click();

 }

  public void fillRequiredFields(String typeNameValue) throws Exception {
		Thread.sleep(2000);
		
///		idTypeName = uiTools.getElementLocatorIdByLabelTextUsingForAttribute2(driver, "Id Type Name");
		driver.findElement(By.xpath(idTypeName)).clear();
  	driver.findElement(By.xpath(idTypeName)).sendKeys(typeNameValue);
  }
  
  public void fillNonRequiredFields() throws Exception {
///    	driver.findElement(By.xpath(idTypeName)).sendKeys(typeNameValue);;
  }   
  
  public void savePage() throws Exception {
  	driver.findElement(By.xpath(saveButton)).click();
  	Thread.sleep(3000);    	
  }
  
  public void editPage() throws Exception {
  	driver.findElement(By.xpath(editButton)).click();
  	Thread.sleep(3000);    	
  }

}
