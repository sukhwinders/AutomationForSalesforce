package utilis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class generalUtils {
	
	 String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	    String DATE_FORMAT_DATE = "yyyy-MM-dd";
	    String DATE_FORMAT_TODAY_DATE = "M/d/yyyy";
	    String DATE_FORMAT_TODAY_DATE_TIME = "M/dd/yyyy hh:mm a";
	    String DATE_FORMAT_TODAY_DATE_TIME2 = "M/d/yyyy hh:mm a";
	    private WebDriver driver;

	    public String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
		//qa
	    }

	    public Date nowSFDCformat() throws Exception {
	        DateFormat formatter = null;
	        Date convertedDate = null;
	    	String currentDate = now().substring(0, 10);
	    	String convertedDate2;
//	        String currentDate = "2015-02-19 12:00:00";
	    	
//	    	Calendar cal = Calendar.getInstance();
//	    	formatter = new SimpleDateFormat(DATE_FORMAT_NOW);
	    	formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
	    	
//	    	formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			convertedDate = formatter.parse(currentDate);
//			System.out.println(convertedDate);
			return convertedDate;
	    }

	    public Date tomorrowSFDCformat() throws Exception {
	        DateFormat formatter = null;
	        Date convertedDate = null;
	    	
	    	formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		    Calendar cal = Calendar.getInstance();        
		    cal.add(Calendar.DATE, 1);     
		    String tommorrow= (String)(formatter.format(cal.getTime()));
			convertedDate = formatter.parse(tommorrow);
//			System.out.println(convertedDate);
			return convertedDate;		
		}

	    public Date todayPlusNumberOfDaysSFDCformat(int numberOfDays) throws Exception {
	        DateFormat formatter = null;
	        Date convertedDate = null;
	    	
	    	formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		    Calendar cal = Calendar.getInstance();        
		    cal.add(Calendar.DATE, numberOfDays);  // number of days to add      
		    String tommorrow= (String)(formatter.format(cal.getTime()));
			convertedDate = formatter.parse(tommorrow);
			return convertedDate;		
		}

	    
	    public String today_date() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE);
		return sdf.format(cal.getTime());
	    }

	    public String today_date_time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME);
		return sdf.format(cal.getTime());
	    }
	    
	    public Date today_date_time2() throws ParseException{
//	    	Calendar cal = Calendar.getInstance();
//	    	Date currentDate = cal.getTime();
	    	Date curDate = new Date();
	    	DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TODAY_DATE_TIME2, Locale.US);
	    	String currentDateTimeStr =  sdf.format(curDate);
	    	Date currentDateTime = sdf.parse(currentDateTimeStr);
//	    	System.out.println("==============" + curDate + "=================");
//	    	System.out.println("==============" + currentDateTime + "=================");
	    	return currentDateTime;
	    }

	    public String getTestRunStartTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;
	    }

	    public String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH.mm");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());

		return dateTime;

	    }
	    
	    public void SFDClogin(String login, String password) throws Exception {
			String SFDCloginXPATH = "//input[@id='username']";
			String SFDCpasswordXPATH = "//input[@id='password']";
			String SFDCLoginButtonXPATH = "//input[@id='Login']";
			
			driver.get("login.salesforce.com");
			driver.findElement(By.xpath(SFDCloginXPATH)).sendKeys(login);
			driver.findElement(By.xpath(SFDCpasswordXPATH)).sendKeys(password);
			driver.findElement(By.xpath(SFDCLoginButtonXPATH)).click();
			Thread.sleep(3000);		
	    }
	    public void switchtoLightining(){
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

	}

	
	

}
