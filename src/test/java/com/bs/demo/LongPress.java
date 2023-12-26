package com.bs.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseClass {
	@Test
	public void longPressTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		WebElement longele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) longele).getId(),"duration",3000));
		WebElement smenu=driver.findElement(By.id("android:id/title"));
		String Peopletext= smenu.getText();
		Assert.assertEquals(Peopletext,"Sample menu");
		
		boolean display=smenu.isDisplayed();
		Assert.assertTrue(display);
	}

}
