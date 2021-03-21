package TestPackage;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileBrowser extends AppiumTestBase {
	
	public static final String username = "abcd@gmail.com";
	public static final String password = "abcd1234";
	public static final String url = "https://ess-staging.ttconline.com/";
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		driver.get(url);
		
		final WebDriverWait wait = new WebDriverWait(driver,5); //Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); 
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("continueBtn")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginBtn")).click();
		
	}

}
