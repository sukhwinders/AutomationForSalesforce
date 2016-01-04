package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SF_HomePage {
	 public SF_HomePage(WebDriver driver){
	  this.driver=driver;
	 }
	 private WebDriver driver;
	   String Username = ".//*[@id='username']";
	   String password = ".//*[@id='password']";
	   String loginButton = ".//*[@id='Login']";
	  
	    
	    //Function to enter valid credentials to the app.
	    public void entercredentials(String uname,String passwd) {
	    driver.findElement(By.xpath(Username)).sendKeys(uname);
	    driver.findElement(By.xpath(password)).sendKeys(passwd);
	    driver.findElement(By.xpath(loginButton)).click();
	    }
}