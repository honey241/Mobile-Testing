
package com.bs.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		/*
		 * Map<String, String> env = new HashMap<String, String>(System.getenv());
		 * env.put("ANDROID_HOME", "C:\\Users\\srava\\AppData\\Local\\Android\\Sdk");
		 * env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-20");
		 */

		// run appium server automatically
		// main.js file is responsible to invoke the appium server. So we need the path
		// of the main.js
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\srava\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
		service.start(); // inside the appiumServiceBuilder,start method is present to kickoff the server

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6a");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		// create object for Android Driver/IOSDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	
	public void scrollToEnd() {
		boolean canscrolldown;
		do {
			canscrolldown = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

		} while (canscrolldown);
	}
	
	public void scrollToElement(String ele) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ele\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"ele\"]")).click();
	}
	
	//perform swipe action
	public void swipeAction(WebElement ele, String swipeDirection) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				  ImmutableMap .of("elementId",((RemoteWebElement) ele).getId(),
				  "direction", swipeDirection, "percent",0.75)); 
	}

	@AfterClass

	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
