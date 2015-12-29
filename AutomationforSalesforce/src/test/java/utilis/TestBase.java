package utilis;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;
import pageObjects.SF_Create_Product_page;
import pageObjects.SF_HomePage;



public class TestBase {
	
	  protected static WebDriver driver;
	   protected String baseUrl;
	   protected SF_HomePage sf_homepage;
	   protected SF_Create_Product_page sf_create_product_page;

	   @BeforeMethod
@BeforeSuite
   public void setUp() {
         baseUrl = "https://login.salesforce.com/";
         driver = new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
         driver.manage().window().maximize();

   }
@AfterMethod
@AfterSuite
   public void tearDown() throws Exception {
         driver.quit();
   }
}

