package com.bs.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class OptimizeBaseClass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium1() throws MalformedURLException {
		/*
		 * Map<String,String> env=new HashMap<String,String>(System.getenv());
		 * env.put("ANDROID_HOME", "C:\\Users\\srava\\AppData\\Local\\Android\\Sdk");
		 * env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-20");
		 */

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\srava\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
		service.start(); // inside the appiumServiceBuilder,start method is present to kickoff the server

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6a");
		options.setPlatformName("Android");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\General-Store.apk");
		options.setChromedriverExecutable("C:\\Selenium\\chromedriver_win32 (10)\\chromedriver.exe");
		// create object for Android Driver/IOSDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// object locators: xpath,id,classname,accessibilityId, androidUIautomator
		// driver.findElement(AppiumBy.accessibilityId("OS")).click();
	}

	@AfterClass

	public void tearDown1() {
		driver.quit();
		service.stop();
	}

}
