package scripts;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SF_HomePage;
import pageObjects.SF_SearchAndConnectPartner;
import utilis.TestBase;

public class sfSearchAndConnectPartner extends TestBase {
	
	@Test
	public void SearchAndConnectPartner() throws Throwable{
		
		sf_homepage = PageFactory.initElements(driver, SF_HomePage.class);
		SF_SearchAndConnectPartner partnerSrcCnt=new SF_SearchAndConnectPartner(driver);		
		//sf_seachconnectpartner = PageFactory.initElements(driver, SF_SearchAndConnectPartner.class);
		
		sf_homepage.entercredentials("sdqa01rk@sd.com", "Test@123");
		sf_homepage.LoginSF();		
		Thread.sleep(2000);		
		sf_homepage.Applaunchericon();	
		Thread.sleep(5000);		
		partnerSrcCnt.DeleteAccount();
		partnerSrcCnt.SearchAndConnectPartner();
		partnerSrcCnt.DefineTpRelationship();
	}
}

