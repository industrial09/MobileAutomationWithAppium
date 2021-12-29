import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumGesturesUsingTouchAction {
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
	
	public AppiumGesturesUsingTouchAction(AppiumDriver driver) {
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
		AppiumGesturesUsingTouchAction mt = new AppiumGesturesUsingTouchAction(driver);
		
		By imageButton = MobileBy.AccessibilityId("ImageButton");
		By animation = MobileBy.AccessibilityId("Animation");
		
		System.out.println("Text gottten for visibility label is: "+ access.getText());
		
		MobileElement access = (MobileElement) driver.findElementByAccessibilityId("Views");
		//******************* TOUCH ACTIONS **********************
		TouchAction action = new TouchAction(driver);
		// **** TAP ****
		action.tap(ElementOption.element(access)).perform();
		//In this case a Mobile element is located using coordinates in X and Y
		//action.tap(PointOption.point(538, 416)).perform();
		//Other way
		//action.tap(TapOptions.tapOptions().withElement(ElementOption.element(access))).perform();
		
		// *** PRESS AND LONG PRESS ***
		//action.press(ElementOption.element(access)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).release().perform();
		// In the Longpress case, there is no need to add wait time for performing such press action
		//action.longPress(ElementOption.element(access)).release().perform();
		//String accessText = access.getText();
		//System.out.println(accessText);
		
		// *** SWIPE action with PRESS and MOVETO commands ***
		//In this case starting point, Appium takes it just like the initial touch point we do in real device
		//and the ending point the point where we release/end the swipe
		
		//1st way:(for is only for scrolling entire content)
		/*for(int i=0; i<2; i++) {
			action.press(PointOption.point(500, 2100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))
					).moveTo(PointOption.point(500, 300)).release().perform();
		}*/
		
		Dimension size = driver.manage().window().getSize();
		int startXPoint = size.width/2;
		int startYPoint = startXPoint;
		int endXPoint = (int) (size.height * 0.1);
		int endYPoint = (int) (size.height * 0.975);
		
		for(int i=0; i<2; i++) {
		action.press(PointOption.point(startYPoint, endYPoint)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))
				).moveTo(PointOption.point(startXPoint, endXPoint)).release().perform();
		}
		
		//2nd way:
		/*action.press(ElementOption.element(driver.findElement(imageButton))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(driver.findElement(animation)))
				.release().perform();*/
		
		/*MobileElement access1 = (MobileElement) driver.findElementById("android:id/action_bar");
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
		System.out.println(accessText6);*/
	}
}
