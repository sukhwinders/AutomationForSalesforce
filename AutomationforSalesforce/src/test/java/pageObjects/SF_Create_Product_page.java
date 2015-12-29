package pageObjects;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pageObjects.SF_Create_Product_page;

public class SF_Create_Product_page {
	
	public SF_Create_Product_page(WebDriver driver) {
		
        this.driver = driver;
  }
	
	private WebDriver driver;
	  	   
	   @FindBy(linkText="ICIX")
		 WebElement Products_Findlist_field;

	   @FindBy(xpath="//a[contains(@href, 'https://sdqa01-dev-ed.my.salesforce.com/a0N/o')]")
		 WebElement Products_ICIX_Select;
	   
	   @FindBy(linkText="New")
		 WebElement New_Products_Button;
	   
	   @FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[1]/label/input")
		 WebElement New_Products_Name_Textfield;
	   
	   @FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[2]/label[2]/input")
		 WebElement New_Products_UPC_Textfield;
	   
	   @FindBy(xpath="html/body/div[1]/div/form/fieldset[2]/div/div[3]/label[1]/button")
	   WebElement New_Products_Search_Button;
	   
	   @FindBy(xpath="html/body/div[1]/div/form[1]/div/label[1]/button")
	   WebElement New_Products_Create_Button;
	   
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
	   
	 //To click on ICIX on image on app launcher screen.
		 public SF_Create_Product_page sf_Products_link_click() {
			Products_Findlist_field.click();
			 return PageFactory.initElements(driver, SF_Create_Product_page.class);
		         
		   }	 
		//To click on specfic ICIX products link on list page.
		 public SF_Create_Product_page sf_ICIXProducts_select_click() {			 
			 Products_ICIX_Select.click();
				 return PageFactory.initElements(driver, SF_Create_Product_page.class);
			         
			   }
		 
		//To click on Create New Button on Products page.
		 public SF_Create_Product_page sf_ICIXProducts_button_click() {
			 New_Products_Button.click();
				 return PageFactory.initElements(driver, SF_Create_Product_page.class);
			         
			   }
		 
		//To enter value in "Relationship Type" drop down.
		 
		 public SF_Create_Product_page Product_RType1(){
		        Select dropdown = new Select(New_Products_Relationship_Type);
		        dropdown.selectByVisibleText("Sell");
		        return PageFactory.initElements(driver, SF_Create_Product_page.class);
		}
		 
         //To select value in "Relationship Status" drop down.
			 public SF_Create_Product_page Product_RStatus(){
		        Select dropdown = new Select(New_Products_Relationship_Status);
		        dropdown.selectByVisibleText("Active");
		        return PageFactory.initElements(driver, SF_Create_Product_page.class);
		}
		 
			//To click on Submit Button to add new Product page.
			 public SF_Create_Product_page sf_ICIXProducts_button_submit() {
				 New_Products_Create_pop_Button.click();
					 return PageFactory.initElements(driver, SF_Create_Product_page.class);
				         
				   }
		//To enter value in product text field and click on search Button on final screen.
		 public SF_Create_Product_page sf_ICIXProducts_Details() throws InterruptedException {
			 System.out.println("This is method to enter details");
			 driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
			 //to enter random numbers in the UPC field
			 String randomNumbers = RandomStringUtils.randomNumeric(8);
			 String UPCproduct = "1111" + randomNumbers;
			//Enter value in UPC textfield.
			 New_Products_UPC_Textfield.sendKeys(UPCproduct);
			 //Enter value in Product name field with unique time:
			 Date d = new Date(System.currentTimeMillis());
			 New_Products_Name_Textfield.sendKeys("Automationtest"+d);
			 System.out.println("User has entered value in the text field");
			 New_Products_Search_Button.click();
			 Thread.sleep(500);	
			 New_Products_Create_Button.click();
			 // Switch to Select realtionship window:
			Product_RType1();
			Product_RStatus();
			sf_ICIXProducts_button_submit();
        	return PageFactory.initElements(driver, SF_Create_Product_page.class);
			         
			   }
		 
		 //To click on Create Button on final screen.
		 public SF_Create_Product_page sf_ICIXProducts_Create_click() {
			 New_Products_Create_Button.click();
				 return PageFactory.initElements(driver, SF_Create_Product_page.class);
			         
			   }

}
