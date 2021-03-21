package TestPackage;

import org.testng.annotations.Test;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

class SeleniumTest {
	
	private static final String url = "https://www.amazon.in/";
	private static final String userName = "Test User 123456";
	private static final String mobileNo = "8096450000";
	private static final String password = "abcdefgh123456";
	private static final String captcha = "123456";
	private static final String errorMessage = "Enter the characters as they are given in the challenge.";
	
	public WebDriver driver;
	public Properties obj;	
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		/*System.setProperty("webdriver.chrome.driver", "//Users//user//Downloads//chromedriver");
		driver = new ChromeDriver();
*/
		
		obj = new Properties();					
	    FileInputStream objfile = new FileInputStream("//Users//user//fe-automation//src//main//resources//ObjectRepository.properties");									
	    obj.load(objfile);		
	    	    driver.get(url);
	}
	
	
	@AfterSuite()
	public void afterSuite(){
		driver.quit();
	}

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		
		//Check if parameter passed from TestNG is 'Firefox'
		if(browser.equalsIgnoreCase("firefox")){
		
			//Create Firefox instance
			System.setProperty("webdriver.gecko.driver", "//Users//user//Downloads//geckodriver");
			driver = new FirefoxDriver();
		}
		
		//Check if parameter passed from TestNG is 'Chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			
			//Create Chrome instance
			System.setProperty("webdriver.chrome.driver","//Users//user//Downloads//chromedriver");
			driver = new ChromeDriver();
		}
		
		
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	}
	
	
	@Test
	public void login() throws InterruptedException{
		
		final WebDriverWait wait = new WebDriverWait(driver,5); //Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(obj.getProperty("SigninButton")))); 
		
		driver.findElement(By.xpath(obj.getProperty("SigninButton"))).click();
		driver.findElement(By.id(obj.getProperty("CreateAmazonAccountButton"))).click();
		driver.findElement(By.id(obj.getProperty("NameTextbox"))).sendKeys(userName);
		driver.findElement(By.id(obj.getProperty("MobileNoTextbox"))).sendKeys(mobileNo);
		driver.findElement(By.id(obj.getProperty("Password"))).sendKeys(password);
		driver.findElement(By.id(obj.getProperty("ContinueButton"))).click();
		driver.findElement(By.xpath(obj.getProperty("CaptchaTextbox"))).sendKeys(captcha);
		driver.findElement(By.className(obj.getProperty("CaptchaContinueButton"))).click();
		Assert.assertEquals(driver.findElement(
				By.cssSelector(obj.getProperty("ErrorMessage"))).getText(),errorMessage); //Verify error message
		
	}
}

