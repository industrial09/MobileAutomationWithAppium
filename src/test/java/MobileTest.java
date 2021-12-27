import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MobileTest {
	//Way of defining locators for Web based mobile apps
	//@FindBy(xpath="//*[@text=\"Accessibility\"]")
	//private static MobileElement access;
	//Way of defining locators for iOS based mobile apps
	//@iOSXCUITFindBy(accessibility = "Accessibility")
	//private static MobileElement access;
	
	//Way of defining locators for Android based mobile apps
	//REMEMBER!! Always try to locate a mobile element with one or another strategy: by xpath, accesibility, etc
	//even when a strategy looks fine
	@AndroidFindBy(accessibility = "Accessibility")
	private static MobileElement access;
	
	public MobileTest(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static void main(String [] args) throws MalformedURLException, InterruptedException {
		//Mobile locators that can be used are:
		//id, accesibilityId, className, xpath, image, AndroidUIAutomator
		AppiumDriver driver = CreateDriverSession.createSessionDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		MobileTest mt = new MobileTest(driver);
		System.out.println("Text gottten for visibility label is: "+ access.getText());
		
		MobileElement access = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
		TouchAction action = new TouchAction(driver);
		action.tap(ElementOption.element(access)).perform();
		//In this case a Mobile element is located using coordinates in X and Y
		action.tap(PointOption.point(538, 416)).perform();
		//Other way
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(access))).perform();
		//String accessText = access.getText();
		//System.out.println(accessText);
		
		MobileElement access1 = (MobileElement) driver.findElementById("android:id/action_bar");
		String accessText1 = access1.getText();
		System.out.println(accessText1);
		
		//In this case findElements can be used to access a specific mobile element, using get()
		MobileElement access2 = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
		String accessText2 = access2.getText();
		System.out.println(accessText2);
		
		//In case of locating a mobile element with AndroidUIAutomator, it can be accessed through:
		// text, className, description and resourceId
		
		MobileElement access3 = (MobileElement) ((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Animation\")");
		String accessText3 = access3.getText();
		System.out.println(accessText3);
		
		MobileElement access4 = (MobileElement) ((FindsByAndroidUIAutomator)driver).findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
		String accessText4 = access4.getText();
		System.out.println(accessText4);
		
		MobileElement access5 = (MobileElement) ((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().description(\"NFC\")");
		String accessText5 = access5.getText();
		System.out.println(accessText5);
		
		MobileElement access6 = (MobileElement) ((FindsByAndroidUIAutomator)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")").get(7);
		String accessText6 = access6.getText();
		System.out.println(accessText6);
	}
}
