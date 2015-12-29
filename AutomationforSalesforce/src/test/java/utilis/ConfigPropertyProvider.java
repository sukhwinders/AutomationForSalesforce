package utilis;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertyProvider {
	
	private String configFileName;
    private static Properties prop = new Properties();
    private final static String projectDir = getProjectDirectory();

    public ConfigPropertyProvider(String configFile) {
       accessConfigFile(configFile);
   }

   public ConfigPropertyProvider() {
       if (configFileName == null) {
           accessConfigFile("config.properties");
           
           
       }
   }

   private void accessConfigFile(String configFile) {
       this.configFileName = configFile;
       System.out.println("Accessing Config property provider file.");
       try {
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
           prop.load(inputStream);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static String getProjectDirectory() {
       String projectDir = System.getProperty("user.dir") + "/";
       if (projectDir.contains("/build/")) {
           projectDir = projectDir.replaceAll("/build/", "/");
       }
       System.out.println("Using base directory as: " + projectDir);
	   return projectDir; // looks like: /Users/balbuque/Documents/workspace/QAAutomation/
    }

    // Method returns a path where Sikuli images are stored
    public String getSikuliImagePath() {
    	String imagePath = projectDir + "images/"; // prop.getProperty("SikuliImagePath");
    	return imagePath;
    }

    // Method returns a path where chromedriver is located
    public String getChromeDriverPath() {
    	String chromePath = projectDir + "lib/chromedriver"; // prop.getProperty("ChromeDriverPath");
    	System.out.println("Chromepath is set at =========>"+chromePath);
    	return chromePath;
    }

    // Method returns a path where InternetExplorerDriver is located
    public String getIeDriver() {
    	String ieDriver = projectDir + "lib/InternetExplorerDriver"; // prop.getProperty("InternetExplorerDriver");
    	return ieDriver;
    }

    public String getScreenshotDir() {
    	String screenshotDir = projectDir + "Screenshots/"; // prop.getProperty("ScreenshotDirectory");
    	return screenshotDir;
    }

    
    // Method to return the username of user assigned to the Sys Admin profile
    public String getSalesforceUserNameDevOrg() {

		String userName = "";

		userName = prop.getProperty("Username");
		try {
			if (userName.equals(null));
		} catch (Exception e) {
			userName = prop.getProperty("package.Username");
		}

		return userName;
	}

    
     //Method to return the password of user assigned to the Sys Admin profile   
    public String getSalesforcePasswordDevOrg() {

    	String password = "";

    	password = prop.getProperty("Password");
    	try {
    		if (password.equals(null));
		} catch (Exception e) {
			password = prop.getProperty("package.Password");
		}
		
    	return password;
    }
    
    public String getSalesforceUserNamePackageOrg()
    {
    	String userNamePackage = prop.getProperty("package.Username");
    	return userNamePackage;
    }
    
    public String getSalesforcePasswordPackageOrg()
    {
    	String passwordPackage = prop.getProperty("package.Password");
    	return passwordPackage;
    }
    
    
    /*
     * Method to return the salesforce login url
     */
    public String getSFDCLoginUrl() {
       String loginUrl = prop.getProperty("Login_Url");
       return loginUrl;
    }

    public String getCompanyName(){
        return prop.getProperty("CompanyName");
    }

//    public String getNamespace(){
//        return prop.getProperty("Namespace");
//    }
    
    /*
     * Method to get TPM namespace
     */
    public String getTPMNamespace(){
    	return prop.getProperty("TPMNamespace");
    }

    /*
     * Method to return the security token of user assigned to the Sys Admin profile
     */
    public String getSecurityTokenDevOrg() {

        String securityToken="";

       securityToken = prop.getProperty("SecurityToken");
       
       try {
    	   if(securityToken.equals(null));
       } catch (Exception e) {
    	   securityToken = prop.getProperty("package.SecurityToken");
       }
       
       return securityToken;
    }
    
    public String getSecurityTokenPackageOrg(){
    	String securityTokenPackage = prop.getProperty("package.SecurityToken");
    	return securityTokenPackage;
    }

    /*
     * Method to return the salesforce custom domain url
     */
    public String getSfdcUrl() {
       String sfdcUrl = prop.getProperty("sfdcUrl");
       return sfdcUrl;
    }

    public String getAuthEndPoint() {
       String authEndPoint = prop.getProperty("AuthEndPoint");
       return authEndPoint;
    }

    public String getServiceEndPoint() {
       String serviceEndPoint = prop.getProperty("ServiceEndPoint");
       return serviceEndPoint;
    }

    public String getBrowserType() {
       String browserType = prop.getProperty("BrowserType");
       return browserType;
    }

    public String getHubURL() {
       String hubURL = prop.getProperty("host");
       return hubURL;
    }

    public boolean getRemoteSettings() {
       boolean remote = Boolean.valueOf(prop.getProperty("UseRemote"));
       return remote;
    }
    
    public String getMaxRetryCount(){
    	return prop.getProperty("MaxRetryAttempts");
    }
    
    public String getScreenShotpath(){
    	return prop.getProperty("screenshotPath");
    }


}
