package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import utilis.seleniumUtils;
import org.openqa.selenium.Keys;

public class SF_SearchAndConnectPartner {
	
	public SF_SearchAndConnectPartner(WebDriver driver){
		this.driver=driver;
	}
	
	private WebDriver driver;
	By IcIxLink=By.linkText("ICIX");
	By lnkAccounts=By.linkText("Accounts");
	String sTblAccounts="/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div[2]/div/div/table/tbody";
	WebElement tblAccounts;
	List <WebElement> RowsOfTable;
	WebElement ColOfTable;
	By tdArrow=By.xpath(".//*[@title='Show More']");
	By lnkDelete=By.xpath(".//*[@title='Delete']");
	By btnDelete=By.xpath(".//*[@title='Delete']");
	By btnNew=By.xpath(".//*[@title='New']");
	String AddAccIframeId="vfFrameId";
	String strTxtCompName="input[id=\"companyName\"]";
	String strBtnSearch=".//*[@class='btn btn-info action']";
	String strBtnConnect="button[class=\"btn btn-connect ng-scope\"]";
	String strBtnSave="button[text=\"Save\"]";
	String strDrpType=".//select[contains(@ng-options,'tradingPartnerRelationshipStatuses')]";
	String strChkAll="input[type=\"checkbox\"]";
	
	//seleniumUtils selUtil=new seleniumUtils();
	
	public void NavigateToAccounts() throws Throwable{
		driver.findElement(IcIxLink).click();
		//driver.findElement(By.linkText(strIcIxLink));		
		Thread.sleep(2000);
		//driver.findElement(By.linkText(strlnkAccounts));
		driver.findElement(lnkAccounts).click();
		Thread.sleep(2000);		
	}
	
	public void DeleteAccount() throws Throwable{
		NavigateToAccounts();
		tblAccounts= driver.findElement(By.xpath(sTblAccounts));		
		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));	
		
		for (int r=0;r<RowsOfTable.size();r++)
		{
			ColOfTable=RowsOfTable.get(r).findElement(By.tagName("td"));
			String tdText=ColOfTable.getText();
			String textToVerify="maheshorg2";
			
			if(tdText.equals(textToVerify))
			{
				RowsOfTable.get(r).findElement(tdArrow).click();
				driver.findElement(lnkDelete).click();
				driver.findElement(btnDelete).click();				
				break;
			}
		}		
	}
	
	public void SearchAndConnectPartner() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(btnNew).click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.id(AddAccIframeId)));
		driver.findElement(By.cssSelector(strTxtCompName)).sendKeys("maheshorg2");
		driver.findElement(By.xpath(strBtnSearch)).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(strBtnConnect)).click();
	}
	
	public void DefineTpRelationship() throws Throwable{
		Thread.sleep(3000);
		
		//Select drpRelationshipType=new Select(driver.findElement(By.xpath(".//select[contains(@ng-options,'tradingPartnerRelationshipTypes')]")));
		//drpRelationshipType.selectByVisibleText("Agent");
		
		Select drpRelationshipSts=new Select(driver.findElement(By.xpath(strDrpType)));
		drpRelationshipSts.selectByVisibleText("Active");
		
		//selUtil.ZoomIn();
		
		for(int i=0; i<3; i++){
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }
		
		Thread.sleep(1000);
		//WebElement chk=driver.findElement(By.xpath("//label[text()='Active']/preceding-sibling::input[@type='checkbox']"));
		//WebElement chk=driver.findElement(By.xpath("//label[text()='Active']/parent::input[@type='checkbox']"));
		//chk.click();
		//driver.findElement(By.xpath("//label[text()='Customer']/following-sibling::input[@type='checkbox']")).click();
		
		List <WebElement> chkAll=driver.findElements(By.cssSelector(strChkAll));
		chkAll.get(1).click();
		chkAll.get(4).click();
		chkAll.get(5).click();
		
		//driver.findElement(By.cssSelector(strBtnSave)).click();;
		
	}
}
