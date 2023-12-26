package com.bs.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollGesture extends BaseClass {
	@Test
	public void ScrollTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(3000);
		//Scroll until
		//scrollToElement("Rating Bar");
		//scrollToEnd();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rating Bar\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Rating Bar\"]")).click();
	}
}
