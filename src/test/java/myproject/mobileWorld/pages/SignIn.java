package myproject.mobileWorld.pages;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignIn {
	WebDriver driver;
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement email = driver.findElement(By.cssSelector("#username"));
//	WebElement password = driver.findElement(By.cssSelector("#password"));
//	WebElement login = driver.findElement(By.cssSelector("a[type='submit']"));
	@FindBy(css="button[type='submit']")
	WebElement loginPage;
	
	@FindBy(css="#username")
	WebElement email;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(css="a[type='submit']")
	WebElement login;
	
	public void toLoginPage() throws InterruptedException {
		Thread.sleep(1000);
		loginPage.click();
	}
	
	public void enterEmail(String setEmail) {
		email.sendKeys(setEmail);
	}
	
	public void enterPassword(String setPassword) {
		password.sendKeys(setPassword);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public boolean isTestPassed() {
		return login.isDisplayed();
	}
	
	public void isEmailTestPassed(String userEmail) {
		if(userEmail.length() < 3 || userEmail.length() > 20) {
			try {
			assertTrue(login.isDisplayed());
			}
			catch(NoSuchElementException ex) {}
		}
		else
			Assert.assertEquals("https://mobileworld.azurewebsites.net/index.html", driver.getCurrentUrl());
	}
	
	public void isPasswordTestPassed(String userPassword) {
		if(userPassword.length() < 3 || userPassword.length() > 10) {
			try {
			assertTrue(login.isDisplayed());
			}
			catch(NoSuchElementException ex) {}
		}
		else
			Assert.assertEquals("https://mobileworld.azurewebsites.net/index.html", driver.getCurrentUrl());
	}
	
	
}
