package pageObjects;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.assertEquals;

import pageObjects.SF_Create_Product_page;


public class SF_Create_Product_page {
	public SF_Create_Product_page(WebDriver driver) {
		
        this.driver = driver;
  }
	
	private WebDriver driver;
	
		String waffle = "//div[@class='icon-waffle']";
	    String Products_Findlist_field = "ICIX";
	    String Products_ICIX_Select = "//a[contains(@href, 'https://sdqa01-dev-ed.my.salesforce.com/a0N/o')]";
	    String New_Products_Button = "//div[contains(@title,'New')]";
	    
	    
	    //String New_Products_UPC_Textfield = "//input[contains(@class, 'slds-input ng-valid ng-valid-maxlength ng-touched ng-dirty ng-valid-parse')]";
	    //@FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[2]/label[2]/input")
		String New_Products_Name_Textfield = "//input[contains(@ng-if='Product Id')]";
	  // @FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[1]/label/input")
		String New_Products_Search_Button = "//button[@type='button']";
	   //@FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[3]/label[1]/button")
		String New_Products_Create_Button = "//button[contains(@ng-click='productCreateShowModal')]";
	   //@FindBy(xpath="html/body/div[1]/div/form[1]/div/label[1]/button")

	   
	   //Define your Product Relationship on pop up
	   @FindBy(xpath="html/body/div/product-connect/div[2]/div/div/div[2]/section[1]/form/fieldset/div/div[2]/label/select")
	 WebElement New_Products_Relationship_Type;
	   
	   @FindBy(xpath="html/body/div[1]/product-connect/div[2]/div/div/div[2]/section[1]/form/fieldset/div/div[3]/label/select")
	   WebElement New_Products_Relationship_Status;
	   
	   @FindBy(xpath="/html/body/div/product-connect/div[2]/div/div/div[2]/section[3]/form/fieldset/div[2]/label/input")
	   WebElement New_Products_Organics_field;
	   
	   @FindBy(xpath="/html/body/div/product-connect/div[2]/div/div/div[2]/section[4]/form/fieldset/div/div[1]/div[2]/input")
	   WebElement New_Products_Test_Attribute_field;
	   
	   @FindBy(xpath="/html/body/div/product-connect/div[2]/div/div/div[3]/button[2]")
	   WebElement New_Products_Create_pop_Button;
	   
	   @FindBy(xpath="html/body/div/product-connect/div[2]/div/div/div[3]/button[1]")
	   WebElement New_Products_Cancel_pop_Button;
	   
	 //Function to click the Applauncher image after user is switched to Lightening.
	   public void Applaunchericon() {
		   driver.findElement(By.xpath(waffle)).click();
		  // assertEquals(driver.findElement(By.cssSelector("h2.title")).getText(), "Quarterly Performance");
	         
	   }

	 //To click on ICIX on image on app launcher screen.
		 public void sf_Products_link_click() {
			driver.findElement(By.linkText(Products_Findlist_field)).click();
			//assertEquals(driver.findElement(By.xpath("//span[contains(.,'ICIX Products')]")).getText(), "ICIX Products");
			
		         
		   }	 
		//To click on specfic ICIX products link on list page.
		 public void sf_ICIXProducts_select_click() {			 
			 driver.findElement(By.xpath(Products_ICIX_Select)).click();
			// assertEquals("Verifying that usr is on the list page to click th icix products link" + driver.findElement(By.xpath("//label[contains(.,'Description')]")).getText(), "DESCRIPTION");
			//System.out.println("After clicking app launcher icon, user is redirecting to the icix products list items");
			
			         
			   }
		
		//To click on Create New Button on Products page.
		 public void sf_ICIXProducts_button_click() {
			 driver.findElement(By.xpath(New_Products_Button)).click();
			         
			   }
		 
		
		//To enter value in product text field and click on search Button on final screen.
		 public void sf_ICIXProducts_Details() throws InterruptedException {
			 System.out.println("This is method to enter details");
			 driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
			 //to enter random numbers in the UPC field
			 String randomNumbers = RandomStringUtils.randomNumeric(8);
			 String UPCproduct = "1111" + randomNumbers;
			//Enter value in UPC textfield.
			 //driver.findElement(By.xpath(New_Products_UPC_Textfield)).sendKeys(UPCproduct);
			 String strTxtAll="input[type=\"select\"]";
			 List <WebElement> txtAll=driver.findElements(By.cssSelector(strTxtAll));
			 System.out.println(txtAll.size());
			 
			 
			 //txtAll.get(0).sendKeys(UPCproduct);
			 
			 //Enter value in Product name field with unique time:
			 Date d = new Date(System.currentTimeMillis());
			 driver.findElement(By.xpath(New_Products_Name_Textfield)).sendKeys("Automationtest"+d);
			 System.out.println("User has entered value in the text field");
			 driver.findElement(By.xpath(New_Products_Search_Button)).click();
			 Thread.sleep(500);	
			 driver.findElement(By.xpath(New_Products_Create_Button)).click();
			 // Switch to Select realtionship window:
//			Product_RType1();
//			Product_RStatus();
//			sf_ICIXProducts_button_submit();
			         
			   }
		 
		 
		//?????
		//To enter value in "Relationship Type" drop down.
		 
//		 public SF_Create_Product_page Product_RType1(){
//		        Select dropdown = new Select(New_Products_Relationship_Type);
//		        dropdown.selectByVisibleText("Sell");
//		        return PageFactory.initElements(driver, SF_Create_Product_page.class);
//		}
//		 
//         //To select value in "Relationship Status" drop down.
//			 public SF_Create_Product_page Product_RStatus(){
//		        Select dropdown = new Select(New_Products_Relationship_Status);
//		        dropdown.selectByVisibleText("Active");
//		        return PageFactory.initElements(driver, SF_Create_Product_page.class);
//		}
//		 
//			//To click on Submit Button to add new Product page.
//			 public SF_Create_Product_page sf_ICIXProducts_button_submit() {
//				 New_Products_Create_pop_Button.click();
//					 return PageFactory.initElements(driver, SF_Create_Product_page.class);
//				         
//				   }
//		
//		 
//		 //To click on Create Button on final screen.
//		 public SF_Create_Product_page sf_ICIXProducts_Create_click() {
//			 New_Products_Create_Button.click();
//				 return PageFactory.initElements(driver, SF_Create_Product_page.class);
//			         
//			   }

}