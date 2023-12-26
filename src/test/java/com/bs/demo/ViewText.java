package com.bs.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ViewText extends BaseClass {
	@Test
	public void textTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Buttons\"]")).click();
		String normalbtn=driver.findElement(AppiumBy.accessibilityId("Normal")).getText();
		Assert.assertEquals(normalbtn, "Normal");
	}

}
