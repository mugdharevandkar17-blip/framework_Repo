package com.comcast.crm.objectrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement sn;
	
	
	public WebElement getSn() {
		return sn;
	}

	public void setSn(WebElement sn) {
		this.sn = sn;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public void setOrgLink(WebElement orgLink) {
		this.orgLink = orgLink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public void setContactlink(WebElement contactlink) {
		this.contactlink = contactlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public void setSignoutlink(WebElement signoutlink) {
		this.signoutlink = signoutlink;
	}
	
	
	public void logout()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(sn);
		
		
		
	}	
	

}

