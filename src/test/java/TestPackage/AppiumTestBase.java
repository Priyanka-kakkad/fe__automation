package TestPackage;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTestBase {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus6TEmulator"); //Running test cases on an Emulator 

		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); //Running test cases on a Browser
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc); //Connecting to Appium server 
		return driver;

	}

}
