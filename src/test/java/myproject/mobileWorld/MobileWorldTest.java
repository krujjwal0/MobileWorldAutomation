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
	
	
	@DataProvider
    public Object[][] emailDataProvider() {
        return new Object [][] {
            {"krujjwal0@gmail.com"},
            {"ujj"}
        };
    }
	
	@DataProvider
    public Object[][] passwordDataProvider() {
        return new Object [][] {
//            {"Password123"},
//            {"Ps"},
            {"Pswd12"}
        };
    }
	
	@DataProvider
    public Object[][] firstName() {
        return new Object [][] {
            {"Ujjwal"}
        };
    }
	
	
	@Test(dataProvider ="emailDataProvider", priority=2)
	public void emailSignInInputField (String userEmail) throws InterruptedException {
		objSignIn.toLoginPage();
		objSignIn.enterEmail(userEmail);
		objSignIn.enterPassword("Hello12");
		objSignIn.clickLogin();
		
		objSignIn.isEmailTestPassed(userEmail);
	}
	
	@Test(dataProvider ="passwordDataProvider", priority=2)
	public void passwordSignInInputField (String userPassword) throws InterruptedException {
		objSignIn.toLoginPage();
		objSignIn.enterEmail("krujjwal0@gmail.com");
		objSignIn.enterPassword(userPassword);
		objSignIn.clickLogin();
		
		objSignIn.isPasswordTestPassed(userPassword);
	}
	
	@Test(dataProvider = "emailDataProvider", priority=1)
	public void register(String firstName) throws InterruptedException {
		objSignIn.toLoginPage();
		objSignUp.clickOnSignUp();
		objSignUp.enterFirstName(firstName);
		objSignUp.enterLastName("Kumar");
		objSignUp.enterEmail("krujjwal0@gmail.com");
		objSignUp.enterPassword("Hello12");
		objSignUp.enterDOB("10/31/2000");
		objSignUp.chooseGender();
		objSignUp.enterMob("9934127879");
		objSignUp.enterShortBio("Hi There");
		objSignUp.clickRegisterButton();
		objSignUp.handleAlertBoxAppeared();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider ="firstName", priority=10)
	public void order (String userFirstName) throws InterruptedException {

		objOrder.clickOnSupport();
		objOrder.clickOnOrder();
		objOrder.switchToOrderPage();
		objOrder.enterFirstName(userFirstName);
		objOrder.enterLastName("Kumar");
		objOrder.enterEmail("krujjwal0@gmail.com");
		objOrder.enterPassword("Hello12");
		objOrder.chooseGender();
		objOrder.enterMobile("9934127879");
		objOrder.enterAddress1("105, Surya Royal Homes");
		objOrder.enterAddress2("Near Indian Public School, Nagavara");
		objOrder.enterCity("Bangalore");
		objOrder.chooseState();
		objOrder.enterZip("530045");
		objOrder.chooseAppleMobile();
		objOrder.enterNumOfMobile("1");
		objOrder.checkTheBox();
		objOrder.clickOnOrderNow();
		objOrder.closeThePopUp();
	}
}
