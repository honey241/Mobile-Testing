package com.bs.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridTest extends OptimizeBaseClass {

	@Test
	public void doHybrid() throws InterruptedException {

		// Scroll and Select Canada option from dropDown
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();

		// Type name in a text field
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anjali");
		driver.hideKeyboard(); // hide Keyboard

		// Select radio option
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);

		// scroll Air Jordan 9 Retro
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		// select Air Jordan 9 Retro
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < count; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);

		// type selenium in google search

		Set<String> contextnames = driver.getContextHandles();
		for (String contextname : contextnames) {
			System.out.println(contextname);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("codenbox");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		

	}

}
