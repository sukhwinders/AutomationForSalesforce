package scripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects.SF_Create_Product_page;
import pageObjects.SF_HomePage;
import utilis.TestBase;

public class sfCreateProduct extends TestBase{

	@BeforeTest
	public void testset() throws Exception{
		System.out.println("Testing sfcreate product");
	}
	
	@Test
	public void testPageObject() throws Exception {
	
		// Properties obj = new Properties();   
		  //Create Object of FileInputStream Class. Pass file path.
		  //FileInputStream objfile = new FileInputStream(System.getProperty("config\\config.properties"));
		  //Pass object reference objfile to load method of Properties object.
		  //obj.load(objfile);
//	    driver.get(obj.getProperty("baseUrl"));
//	    salesloginpage.setUserName(obj.getProperty("strUserName"));
//	    salesloginpage.setPassword(obj.getProperty("strPassword"));
		
	sf_homepage = PageFactory.initElements(driver, SF_HomePage.class);
	sf_create_product_page = PageFactory.initElements(driver, SF_Create_Product_page.class);
	
	
	
	 driver.get(baseUrl);
	 sf_homepage.entercredentials("sdqa01rk@sd.com", "Test@123");
	 sf_homepage.LoginSF();
	  if(isElementPresent(driver, By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[2]/div/div/div[1]/span"))){
	       driver.findElement(By.id("userNavLabel")).click();
	        driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']")).click();
	        String parentWindow= driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();
	        for(String curWindow : allWindows){
	            driver.switchTo().window(curWindow);
	        //perform operation on popup
	            driver.findElement(By.id("simpleDialog0button0")).click();
	         // switch back to parent window
	     driver.switchTo().window(parentWindow);
	     driver.navigate().refresh();
	        }
	        }
	        
	  sf_homepage.Applaunchericon();
	  //sf_homepage.LogoutSF(); 
	  System.out.println("User has clicked App launcher icon and redirected to respective page");
	  Thread.sleep(5000);
	  sf_create_product_page.sf_Products_link_click();
	  Thread.sleep(1000);
	  sf_create_product_page.sf_ICIXProducts_select_click();
	  Thread.sleep(1000);
	  sf_create_product_page.sf_ICIXProducts_button_click();
	  Thread.sleep(500);
	  sf_create_product_page.sf_ICIXProducts_Details();
	  sf_create_product_page.sf_ICIXProducts_Create_click();
	  Thread.sleep(2000);
	}
	        public static boolean isElementPresent(WebDriver driver, By bydriver)
	     {
	         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	      try
	         {
	             driver.findElement(bydriver);
	             return true;
	         }
	         catch(NoSuchElementException e){
	             return false;
	         }
	 
	 
	 //sf_homepage.LogoutSF();
	 }

}
