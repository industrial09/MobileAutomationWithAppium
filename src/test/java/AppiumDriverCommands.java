import java.io.File;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumDriverCommands {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriver driver = CreateDriverSession.createSessionDriver();
		
		//******* Commands to interact with app being tested
		// such commands seems not be available for current changes
		//Argument for this commands is the appPackage name
		//which can be gotten in 2 ways: 
		//1) Execute in cmd next command: adb shell dumpsys window | grep -E mCurrentFocus
		//2) Installing Apk info app in real device
		/*driver.terminateApp("io.appium.android.apis");
		Thread.sleep(3000);
		driver.queryAppState("io.appium.android.apis");
		driver.activateApp("io.appium.android.apis");
		Thread.sleep(3000);
		driver.isAppInstalled("io.appium.android.apis");
		Thread.sleep(2000);
		driver.queryAppState("io.appium.android.apis");
		
		String appLocation = System.getProperty("user.dir")+ File.separator + "ApiDemos-debug.apk";
		//appLocation is the path where our app already exists and ready to be used
		//withReplaceEnabled() function upgrades app in case of existing one in device
		driver.installApp(appLocation, new AndroidInstallApplicationOptions().withReplaceEnabled());*/
		
		//************ LOCK and UNLOCK commands
		/*((AndroidDriver) driver).lockDevice();
		System.out.println(((AndroidDriver) driver).isDeviceLocked());
		((AndroidDriver) driver).unlockDevice();*/
		
		//********* KEY EVENTS commands
		//For all of the key events look at: https://developer.android.com/reference/android/view/KeyEvent
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALCULATOR));
	}
}
