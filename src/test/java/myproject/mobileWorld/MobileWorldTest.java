package myproject.mobileWorld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myproject.mobileWorld.pages.Order;
import myproject.mobileWorld.pages.SignIn;
import myproject.mobileWorld.pages.SignUp;

public class MobileWorldTest {
	WebDriver driver = new ChromeDriver();
	SignIn objSignIn = new SignIn(driver);
	SignUp objSignUp = new SignUp(driver);
	Order objOrder = new Order(driver);
	
	@BeforeMethod
	public void initiateSession() {
		driver.get("https://mobileworld.banyanpro.com/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void terminateSession() {
		driver.quit();
	}
	
	//****************************************************************\\
	//*************SignUp Data Provider & Test Method*****************\\
	//****************************************************************\\
	@DataProvider
	public Object[][] signUpDataProvider() {
		  return new Object[][] {
		      new Object[] { "Ujjwal", "Kumar" ,"krujjwal0@gmail.com", "Pass1", "10/31/2000", "9934127879", "Hi There"},
		      new Object[] { "U", "Kumar" ,"ujjwal.k@qt.com", "Pass2", "10/31/1999", "1111111111", "Hi Hello"},
		      new Object[] { "RandomStringToInsertMoreThanTwentyCharacter", "LastName" ,"ujjwal.k@qt.com", "Pass2", "01/01/2000", "1111111111", "Hi Third"},
			  new Object[] { "Ujjwal", "K" ,"krujjwal0@gmail.com", "Pass1", "10/31/2000", "9934127879", "Hi There"},
			  new Object[] { "Ujjwal", "Kumar" ,"krujjwal0@gmail.com", "PS", "10/31/2000", "9934127879", "Hi There"},
			  new Object[] { "Ujjwal", "Kumar" ,"krujjwal0@gmail.com", "Pass1", "10/31/2000", "9934127879678", "Hi There"},
		  };
	}
	
	@Test(dataProvider = "signUpDataProvider", priority=1)
	public void register(String firstName, String lastName, String email, String password,
			String DOB, String mobile, String shortBio ) throws InterruptedException {
		objSignIn.toLoginPage();
		objSignUp.clickOnSignUp();
		objSignUp.enterFirstName(firstName);
		objSignUp.enterLastName(lastName);
		objSignUp.enterEmail(email);
		objSignUp.enterPassword(password);
		objSignUp.enterDOB(DOB);
		objSignUp.chooseGender();
		objSignUp.enterMob(mobile);
		objSignUp.enterShortBio(shortBio);
		objSignUp.clickRegisterButton();
		objSignUp.handleAlertBoxAppeared(firstName, lastName, password, mobile);
		Thread.sleep(2000);
	}
	
	//****************************************************************\\
	//*************SignIn Data Provider & Test Method*****************\\
	//****************************************************************\\
	@DataProvider
	public Object[][] signInDataProvider() {
		  return new Object[][] {
		      new Object[] { "krujjwal0@gmail.com", "Passwd12"},
		      new Object[] { "uk", "Pswd23"},
		      new Object[] { "krujjwal0@gmail.com", "Ps"},
		      new Object[] { "ujjwal.kr@gmail.com", "Password1234"},
		  };
	}
	
	@Test(dataProvider ="signInDataProvider", priority=2)
	public void signInMethod (String userEmail, String userPassword) throws InterruptedException {
		objSignIn.toLoginPage();
		objSignIn.enterEmail(userEmail);
		objSignIn.enterPassword(userPassword);
		objSignIn.clickLogin();
		
		objSignIn.isEmailTestPassed(userEmail);
		objSignIn.isPasswordTestPassed(userPassword);
	}
	
	//****************************************************************\\
	//*************Order Data Provider & Test Method******************\\
	//****************************************************************\\
	
	@DataProvider
	public Object[][] orderDataProvider() {
		  return new Object[][] {
		      new Object[] {"Ujjwal", "Kumar" ,"krujjwal0@gmail.com", "Pass1", "9934127879", "105, Surya Royal Homes",
		    		  "Near Indian Public School, Nagavara","Bangalore", "530045", "1"}
		  };
	}
	@Test(dataProvider ="orderDataProvider", priority=3)
	public void orderMethod(String firstName, String lastName, String email, String password, String mobile, 
			String address1, String address2, String city, String zip, String numOfMobile) throws InterruptedException {
		objOrder.clickOnSupport();
		objOrder.clickOnOrder();
		objOrder.switchToOrderPage();
		objOrder.enterFirstName(firstName);
		objOrder.enterLastName(lastName);
		objOrder.enterEmail(email);
		objOrder.enterPassword(password);
		objOrder.chooseGender();
		objOrder.enterMobile(mobile);
		objOrder.enterAddress1(address1);
		objOrder.enterAddress2(address2);
		objOrder.enterCity(city);
		objOrder.chooseState();
		objOrder.enterZip(zip);
		objOrder.chooseAppleMobile();
		objOrder.enterNumOfMobile(numOfMobile);
		objOrder.checkTheBox();
		objOrder.clickOnOrderNow();
		objOrder.closeThePopUp();
	}
}
