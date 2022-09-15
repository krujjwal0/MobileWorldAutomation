package myproject.mobileWorld.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	WebDriver driver;
	public SignUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Sign up")
	WebElement signUp;
	
	@FindBy(id="myName")
	WebElement firstName;
	
	@FindBy(css="input[placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(css="input[type='Email']")
	WebElement email;
	
	@FindBy(css="input[type='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='date']")
	WebElement dob;
	
	@FindBy(xpath="(//input[@name='gender'])[1]")
	WebElement gender;
	
	@FindBy(css="input[type='number']")
	WebElement mob;
	
	@FindBy(xpath="//textarea[@placeholder='Short Bio']")
	WebElement bio;
	
	@FindBy(css="button[type='submit']")
	WebElement registerButton;
	
	public void clickOnSignUp() {
		signUp.click();
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
	
	public void enterDOB(String userDOB) {
		dob.sendKeys(userDOB);
	}
	
	public void chooseGender() {
		gender.click();
	}
	
	public void enterMob(String userMobile) {
		mob.sendKeys(userMobile);
	}
	
	public void enterShortBio(String userBio) {
		bio.sendKeys(userBio);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	@SuppressWarnings("deprecation")
	public void handleAlertBoxAppeared() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
	
	
	

}
