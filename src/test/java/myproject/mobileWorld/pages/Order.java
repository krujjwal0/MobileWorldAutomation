package myproject.mobileWorld.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Order {
WebDriver driver;
	
	public Order(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Support")
	WebElement support;
	
	@FindBy(linkText="Order")
	WebElement order;
	
	@FindBy(xpath="(//input[@id='inputFirstName'])[1]")
	WebElement firstName;
	
	@FindBy(xpath="(//input[@id='inputFirstName'])[2]")
	WebElement lastName;
	
	@FindBy(id="inputEmail")
	WebElement email;
	
	@FindBy(id="inputPassword")
	WebElement password;
	
	@FindBy(id="flexRadioDefault1")
	WebElement gender;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement mob;
	
	@FindBy(xpath="(//input[@id=' address1'])[1]")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="inputCity")
	WebElement city;
	
	@FindBy(id="inputState")
	WebElement state;
	
	@FindBy(id="inputZip")
	WebElement zip;
	
	@FindBy(xpath="//input[@rel='apple']")
	WebElement appleMobile;
	
	@FindBy(xpath="//div[@class='apple']//option[2]")
	WebElement appleModel;
	
	@FindBy(xpath="//input[@placeholder='no of mobiles']")
	WebElement mobCount;
	
	public void clickOnSupport() {
		support.click();
	}
	
	public void clickOnOrder() {
		order.click();
	}
	
	public void switchToOrderPage() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		@SuppressWarnings("unused")
		String parentId = (String) it.next();
		String childId = (String) it.next();
		driver.switchTo().window(childId);
	}
	
	public void enterFirstName(String userFirstName) {
		firstName.sendKeys(userFirstName);
	}
	
	public void enterLastName(String userLastName) {
		lastName.sendKeys(userLastName);
	}
	
	public void enterEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void chooseGender() {
		gender.click();
	}
	
	public void enterMobile(String userMobile) {
		mob.sendKeys(userMobile);
	}
	
	public void enterAddress1(String userAddress1) {
		address1.sendKeys(userAddress1);
	}
	
	public void enterAddress2(String userAddress2) {
		address2.sendKeys(userAddress2);
	}
	
	public void enterCity(String userCity) {
		city.sendKeys(userCity);
	}
	
	public void chooseState() {
		Select S=new Select(state);
		S.selectByIndex(2);
	}
	
	public void enterZip(String userCityZip) {
		zip.sendKeys(userCityZip);
	}
	
	public void chooseAppleMobile() throws InterruptedException {
		appleMobile.click();
		driver.findElement(By.xpath("//input[@rel='samsung']")).click();
		Thread.sleep(1000);
		appleModel.click();
	}
	
	public void enterNumOfMobile(String userMobCount) {
		mobCount.sendKeys(userMobCount);
	}
	
	public void checkTheBox() throws InterruptedException {
		WebElement Count = driver.findElement(By.id("bought"));
		Select s3= new Select( Count );
		s3.selectByIndex(1);
		Thread.sleep(2000);
		List<WebElement> a=driver.findElements(By.id("gridCheck1"));
		((WebElement) a.get(0)).click();
		((WebElement) a.get(1)).click();
	}
	
	public void clickOnOrderNow() {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}
	
	public void closeThePopUp() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
	Thread.sleep(1000);
	}
}
