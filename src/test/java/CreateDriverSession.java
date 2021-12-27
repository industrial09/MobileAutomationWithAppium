import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateDriverSession {
	//Steps to do as part of setup for creating a Driver session with a Connected Real Device
	//Add Selenium jar and Appium jar for Java
	//Add Appium Java client and Selenium Java
	public static void main(String[] args) throws MalformedURLException {
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM A715F");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");*/
		
		//****** In case of an Android Virtual Device, do following steps: ********
		//dc.setCapability("avd", "avd_name_in_Android_Studio");
		//dc.setCapability("avdLaunchTimeOut", 60000);
		
		/*String appPath = System.getProperty("user.dir")+ File.separator + "ApiDemos-debug.apk";
		dc.setCapability(MobileCapabilityType.APP, appPath);*/
		
		//****** In case of having the app installed in the real device, do following steps: ********
		//Open mobile application in real device
		//Execute in cmd next command: adb shell dumpsys window | grep -E mCurrentFocus
		//Second option is installing Apk info app in real device
		//Get appPackage, which is the first part before the 1st /
		//Get appActivity, which is the part after the 1st /
		//Add following code as part of creating a new driver session
		//dc.setCapability("appPackage", "io.appium.android.apis");
		//dc.setCapability("appActivity", ".ApiDemos");
		
		/*URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		AppiumDriver androidCon = new AndroidDriver(url, dc);*/
	}
	
	public static AppiumDriver createSessionDriver() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM A715F");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		String appPath = System.getProperty("user.dir")+ File.separator + "ApiDemos-debug.apk";
		dc.setCapability(MobileCapabilityType.APP, appPath);
		/*dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");*/
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		 
		
		return new AndroidDriver(url, dc);
	}

}
