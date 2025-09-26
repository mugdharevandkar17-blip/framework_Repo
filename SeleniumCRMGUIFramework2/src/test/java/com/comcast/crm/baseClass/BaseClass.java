package com.comcast.crm.baseClass;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.databaseUtility.DataBaseUtility;
import com.comcast.crm.fileUtility.FileUtility;
import com.comcast.crm.webdriverUtility.WebDriverUtility;

public class BaseClass {
	WebDriver driver=null;
	private DataBaseUtility dbs=new DataBaseUtility();
	private FileUtility fu=new FileUtility();
	private WebDriverUtility wdu=new WebDriverUtility();
	
	@BeforeSuite
	public void configBS() throws IOException {
		dbs.getDBConnection();
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		String BROWSER = fu.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		if (driver != null) {
            driver.manage().window().maximize();
            wdu.waitForPageLoad(driver);
	}

}
	  @BeforeMethod
	  public void configBM() throws IOException {
		  String URL = fu.getDataFromPropertiesFile("url");
		  String USERNAME = fu.getDataFromPropertiesFile("username");
		  String PASSWORD = fu.getDataFromPropertiesFile("password");
		  
	  }
	  
	  
	  @AfterMethod
	  public void configAM() {
		  System.out.println("Logout from app");
	  }
	  
	  
	  @AfterClass
	  public void configAC() {
		  System.out.println("close browser");
		  driver.quit();
	  }
	  
	  @AfterSuite
	  public void configAS() {
		  dbs.closeDBconnection();
	  }
	  
	  
	  
}
