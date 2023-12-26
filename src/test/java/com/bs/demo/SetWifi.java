package com.bs.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SetWifi extends BaseClass{
	
    @Test
    public void setWifiTest() {
    	
		// object locators: xpath,id,classname,accessibilityId, androidUIautomator
    	// xpath: //tagname[@attribute='value']; //tagname
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("no123");
		//driver.findElement(By.id("android:id/button1")).click();
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}

}
